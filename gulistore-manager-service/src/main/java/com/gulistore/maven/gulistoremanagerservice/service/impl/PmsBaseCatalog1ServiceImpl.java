package com.gulistore.maven.gulistoremanagerservice.service.impl;


import bean.PmsBaseCatalog1;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog1Mapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseCatalog1Service;

import java.util.List;

@Service
public class PmsBaseCatalog1ServiceImpl implements PmsBaseCatalog1Service {

    @Autowired
    private PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Override
    public List<PmsBaseCatalog1> selectCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }
}
