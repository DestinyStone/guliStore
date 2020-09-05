package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsBaseSaleAttr;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseSaleAttrMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseSaleAttrService;

import java.util.List;

@Service
public class PmsBaseSaleAttrServiceImpl implements PmsBaseSaleAttrService {

    @Autowired
    private PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseSaleAttr> getSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
