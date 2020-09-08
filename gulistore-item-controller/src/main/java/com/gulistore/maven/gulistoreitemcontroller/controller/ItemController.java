package com.gulistore.maven.gulistoreitemcontroller.controller;

import bean.PmsProductSaleAttr;
import bean.PmsSkuInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PmsProductSaleAttrService;
import service.PmsSkuInfoService;

import java.util.List;

@Controller
public class ItemController {

    @Reference
    private PmsSkuInfoService pmsSkuInfoService;

    @Reference
    private PmsProductSaleAttrService pmsProductSaleAttrService;

    @RequestMapping("{skuId}.html")
    public String getSku(@PathVariable Long skuId, Model model) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.selectById(skuId);
        model.addAttribute("skuInfo", pmsSkuInfo);

        List<PmsProductSaleAttr> pmsProductSaleAttrList =  pmsProductSaleAttrService.getSpuSaleAttrAndAllList(skuId);
        model.addAttribute("spuSaleAttrListCheckBySku", pmsProductSaleAttrList);
        return "item";
    }
}
