package com.gulistore.maven.gulistoremanagercontroller.controller;

import bean.PmsBaseSaleAttr;
import bean.PmsProductImage;
import bean.PmsProductInfo;
import bean.PmsProductSaleAttr;
import com.gulistore.maven.gulistoremanagercontroller.utils.UploadUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.PmsBaseSaleAttrService;
import service.PmsProductImageService;
import service.PmsProductInfoService;
import service.PmsProductSaleAttrService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PmsProductInfoController {

    @Reference
    private PmsProductInfoService pmsProductInfoService;

    @Reference
    private PmsBaseSaleAttrService pmsBaseSaleAttrService;

    @Reference
    private PmsProductSaleAttrService pmsProductSaleAttrService;

    @Reference
    private PmsProductImageService pmsProductImageService;

    @GetMapping("/spuList")
    @ApiOperation(value = "获取spu属性", notes = "根据三级分类id获取")
    public List<PmsProductInfo> getSpuList(@RequestParam("catalog3Id") Long id) {
        return pmsProductInfoService.getProductInfoListByCatalog3Id(id);
    }

    @PostMapping("/fileUpload")
    @ApiOperation(value = "上传spu图片")
    public String fuilUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return UploadUtils.FastUpload(multipartFile);
    }

    @PostMapping("/baseSaleAttrList")
    @ApiOperation("获取spu销售属性")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrService.getSaleAttrList();
    }

    @PostMapping("/saveSpuInfo")
    @ApiOperation("保存spu属性")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        return pmsProductInfoService.insertProductInfo(pmsProductInfo);
    }

    @GetMapping("/spuSaleAttrList")
    @ApiOperation(value = "获取spu销售属性", notes = "根据spuId获取")
    public List<PmsProductSaleAttr> spuSaleAttrList(@RequestParam("spuId") Long spuId) {
        return pmsProductSaleAttrService.getSpuSaleAttrList(spuId);
    }

    @GetMapping("/spuImageList")
    @ApiOperation(value = "获取spu图片列表", notes = "根据spuId获取")
    public List<PmsProductImage> spuImageList(@RequestParam("spuId") Long spuId) {
        return pmsProductImageService.selectSpuImageListBySpuId(spuId);
    }
}
