package com.gulistore.maven.gulistoremanagercontroller.controller;

import bean.PmsBaseCatalog1;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PmsBaseCatalog1Service;

import java.util.List;

@Controller
@RestController
public class PmsBaseCatalogController {

    @Reference
    private PmsBaseCatalog1Service pmsBaseCatalogService;

    @GetMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalogService.selectCatalog1();
    }

}
