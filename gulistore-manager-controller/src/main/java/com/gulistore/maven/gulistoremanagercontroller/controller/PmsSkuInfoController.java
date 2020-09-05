package com.gulistore.maven.gulistoremanagercontroller.controller;

import bean.PmsSkuInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.PmsSkuInfoService;

@RestController
@CrossOrigin
public class PmsSkuInfoController {

    @Reference
    private PmsSkuInfoService pmsSkuInfoService;

    @PostMapping("/saveSkuInfo")
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return pmsSkuInfoService.insertPmsSkuInfo(pmsSkuInfo);
    }
}
