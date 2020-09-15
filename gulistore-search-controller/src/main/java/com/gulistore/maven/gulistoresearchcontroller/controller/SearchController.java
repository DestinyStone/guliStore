package com.gulistore.maven.gulistoresearchcontroller.controller;

import bean.PmsBaseAttrInfo;
import bean.PmsSearchParam;
import esbean.PmsSkuInfoSearch;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.PmsBaseAttrInfoService;
import service.PmsSkuInfoSearchService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SearchController {

    @Reference
    private PmsSkuInfoSearchService pmsSkuInfoSearchService;

    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @GetMapping("index.html")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("list.html")
    public String list(PmsSearchParam pmsSearchParam, Model model) {
        if (pmsSearchParam == null) {
            return "404";
        }
        List<PmsSkuInfoSearch> pmsSkuInfoSearchList = pmsSkuInfoSearchService.select(pmsSearchParam);
        if (pmsSkuInfoSearchList == null) {
            return "404";
        }
        model.addAttribute("skuLsInfoList", pmsSkuInfoSearchList);

//
        Long[] integers = filterRepetitionValueId(pmsSkuInfoSearchList);
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = pmsBaseAttrInfoService.selectByValueId(integers);

        if (pmsSearchParam.getValueId() != null) {
            pmsBaseAttrInfoList = pmsBaseAttrInfoList.stream().filter(pmsBaseAttrInfo -> {
                return  !pmsBaseAttrInfo.getAttrValueList().stream().anyMatch(pmsBaseAttrValue -> {
                    for (String id : pmsSearchParam.getValueId()) {
                        if (pmsBaseAttrValue.getId().equals(new Long(id))) {
                            return true;
                        }
                    }
                    return false;
                });
            }).collect(Collectors.toList());
        }

        model.addAttribute("attrList", pmsBaseAttrInfoList);
        model.addAttribute("urlParam", setUrlParam(pmsSearchParam));

        return "list";
    }

    private Long[] filterRepetitionValueId(List<PmsSkuInfoSearch> pmsSkuInfoSearchList) {
        if (pmsSkuInfoSearchList.size() == 0) return null;

        Stream<Long> longStream = pmsSkuInfoSearchList.stream().flatMap(pmsSkuInfoSearch -> {
            Stream<Long> distinct = pmsSkuInfoSearch.getSkuAttrValueList().stream().map(x -> x.getValueId());
            return distinct;
        }).distinct().sorted();
        return longStream.toArray(Long[]::new);
    }

    private String setUrlParam(PmsSearchParam pmsSearchParam) {
        String urlParam = "";

        if (!StringUtils.isBlank(pmsSearchParam.getKeyword())) {
            urlParam += "keyword=" + pmsSearchParam.getKeyword();
        }

        if (pmsSearchParam.getValueId() != null) {
            for (String id : pmsSearchParam.getValueId()) {
                urlParam += "&valueId=" + id;
            }
        }
        return urlParam;
    }
}
