package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsBaseCatalog3;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog3Mapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseCatalog3Service;

import java.util.List;

@Service
public class PmsBaseCatalog3ServiceImpl implements PmsBaseCatalog3Service {

    @Autowired
    private PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog3> selectCatalog3ByCatalog2Id(Long id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = PmsBaseCatalog3.builder().catalog2Id(id).build();
        return pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
    }
}
