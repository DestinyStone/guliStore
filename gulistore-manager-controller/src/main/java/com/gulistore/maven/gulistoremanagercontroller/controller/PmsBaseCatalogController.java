package com.gulistore.maven.gulistoremanagercontroller.controller;

import bean.PmsBaseCatalog1;
import bean.PmsBaseCatalog2;
import bean.PmsBaseCatalog3;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PmsBaseCatalog1Service;
import service.PmsBaseCatalog2Service;
import service.PmsBaseCatalog3Service;

import java.util.List;

@Controller
@RestController
@CrossOrigin
public class PmsBaseCatalogController {

    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalog1Service;

    @Reference
    private PmsBaseCatalog2Service pmsBaseCatalog2Service;

    @Reference
    private PmsBaseCatalog3Service pmsBaseCatalog3Service;

    @PostMapping("/getCatalog1")
    @ApiOperation(value = "获取一级目录", notes = "获取全部")
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Service.selectCatalog1();
    }

    @PostMapping("/getCatalog2")
    @ApiOperation(value = "获取二级目录", notes = "根据一级目录id获取")
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam(value = "catalog1Id") Long id) {
        return pmsBaseCatalog2Service.selectCatalog2ByCatalog1Id(id);
    }

    @PostMapping("/getCatalog3")
    @ApiOperation(value = "获取三级目录", notes = "根据二级目录id获取")
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam(value = "catalog2Id") Long id) {
        return pmsBaseCatalog3Service.selectCatalog3ByCatalog2Id(id);
    }
}
