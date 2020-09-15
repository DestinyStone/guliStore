package com.gulistore.maven.gulistoresearchservice;

import bean.PmsSearchParam;
import bean.PmsSkuInfo;
import com.gulistore.maven.gulistoresearchservice.repository.PmsSkuInfoSearchRepository;
import esbean.PmsSkuInfoSearch;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.PmsSkuInfoSearchService;
import service.PmsSkuInfoService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GulistoreSearchServiceApplicationTests {

    @Reference
    private PmsSkuInfoService pmsSkuInfoService;

    @Autowired
    private PmsSkuInfoSearchRepository pmsSkuInfoSearchRepository;

    @Reference
    private PmsSkuInfoSearchService pmsSkuInfoSearchService;

    @Test
    void contextLoads() {
        List<PmsSkuInfo> pmsSkuInfoList = pmsSkuInfoService.selectAll();
        List<PmsSkuInfoSearch> pmsSkuInfoSearchList = new ArrayList<>();
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfoList) {
            PmsSkuInfoSearch pmsSkuInfoSearch = new PmsSkuInfoSearch();
            BeanUtils.copyProperties(pmsSkuInfo, pmsSkuInfoSearch);
            pmsSkuInfoSearchList.add(pmsSkuInfoSearch);
        }
        pmsSkuInfoSearchRepository.saveAll(pmsSkuInfoSearchList);
    }

    @Test
    public void test03() {
        PmsSearchParam 小米 = PmsSearchParam.builder().keyword("小米").valueId(new String[]{"42", "43"}).build();
        List<PmsSkuInfoSearch> select = pmsSkuInfoSearchService.select(小米);
        select.forEach(System.out::println);

    }

}
