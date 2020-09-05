package com.gulistore.maven.gulistoremanagercontroller.controller;

import bean.PmsBaseAttrInfo;
import bean.PmsBaseAttrValue;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import service.PmsBaseAttrInfoService;
import service.PmsBaseAttrValueService;

import java.util.List;

@RestController
@CrossOrigin
public class PmsBaseAttrInfoController {

    @Reference
    private PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @Reference
    private PmsBaseAttrValueService pmsBaseAttrValueService;

    @GetMapping("/attrInfoList")
    @ApiOperation(value = "获取平台属性", notes = "根据三级目录id获取")
    public List<PmsBaseAttrInfo> attrInfoList(@RequestParam("catalog3Id") Long id) {
        return pmsBaseAttrInfoService.getAttrInfoListByCatalog3Id(id);
    }

    @PostMapping("/getAttrValueList")
    @ApiOperation(value = "获取平台属性值", notes = "根据平台属性id获取")
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam("attrId") Long id) {
        return pmsBaseAttrValueService.getAttrValueList(id);
    }

    @PostMapping("/saveAttrInfo")
    @ApiOperation(value = "保存平台属性值")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        return pmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfo);
    }

}
