package com.gulistore.maven.gulistoresearchservice.service.impl;

import bean.PmsSearchParam;
import com.alibaba.fastjson.JSONObject;
import esbean.PmsSkuInfoSearch;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import service.PmsSkuInfoSearchService;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class PmsSkuInfoSearchServiceImpl implements PmsSkuInfoSearchService {

    private static Map<String, Field> keyMap = new HashMap<>();

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<PmsSkuInfoSearch> select(PmsSearchParam pmsSearchParam) {

        // 构建查询条件
        NativeSearchQuery nativeSearchQuery = customSearchQuery(pmsSearchParam);

        // 查询
        List<PmsSkuInfoSearch> pmsSkuInfoSearchList = new ArrayList<>();
        elasticsearchTemplate.queryForPage(nativeSearchQuery, PmsSkuInfoSearch.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {

                SearchHits hits = response.getHits();
                for (SearchHit hit : hits) {
                    PmsSkuInfoSearch pmsSkuInfoSearch = JSONObject.parseObject(hit.getSourceAsString(), PmsSkuInfoSearch.class);

                    Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                    Iterator<String> iterator = highlightFields.keySet().iterator();
                    while (iterator.hasNext()) {
                        String key = iterator.next();
                        try {
                            Field field = getField(PmsSkuInfoSearch.class, key);
                            field.set(pmsSkuInfoSearch, highlightFields.get(key).getFragments()[0].string());
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    pmsSkuInfoSearchList.add(pmsSkuInfoSearch);
                }
                return null;
            }
            @Override
            public <T> T mapSearchHit(SearchHit searchHit, Class<T> type) {
                return null;
            }
        });



        return pmsSkuInfoSearchList;
    }


    private NativeSearchQuery customSearchQuery(PmsSearchParam pmsSearchParam) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if (pmsSearchParam.getValueId() != null ) {
            for (String id : pmsSearchParam.getValueId()) {
                boolQueryBuilder.filter(QueryBuilders.termsQuery("skuAttrValueList.valueId", id));
            }
        }

        if (!StringUtils.isBlank(pmsSearchParam.getKeyword())) {
            boolQueryBuilder.must(QueryBuilders.multiMatchQuery(pmsSearchParam.getKeyword(), "skuName", "skuDesc"));
        }
        return nativeSearchQueryBuilder
                .withQuery(boolQueryBuilder)
                .withHighlightBuilder(new HighlightBuilder().field("skuName").field("skuDesc").numOfFragments(0).preTags("<span style=\"color:red;\">").postTags("</span>"))
                .withPageable(PageRequest.of(0, 30))
                .build();
    }


    private <T> Field getField(Class<T> clazz, String key) throws NoSuchFieldException {

        if (keyMap.keySet().contains(key)) {
            return keyMap.get(key);
        }
        Field declaredField = clazz.getDeclaredField(key);
        declaredField.setAccessible(true);
        keyMap.put(key, declaredField);
        return declaredField;
    }
}
