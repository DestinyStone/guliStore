package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsBaseCatalog2;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseCatalog2Mapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseCatalog2Service;

import java.util.List;

@Service
public class PmsBaseCatalog2ServiceImpl implements PmsBaseCatalog2Service {

    @Autowired
    private PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;


    @Override
    public List<PmsBaseCatalog2> selectCatalog2ByCatalog1Id(Long id) {
        PmsBaseCatalog2 pmsBaseCatalog2 = PmsBaseCatalog2.builder().catalog1Id(id).build();
        return pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
    }

}
