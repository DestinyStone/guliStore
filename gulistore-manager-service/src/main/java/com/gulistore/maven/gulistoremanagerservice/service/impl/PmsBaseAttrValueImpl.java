package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsBaseAttrValue;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsBaseAttrValueService;

import java.util.List;

@Service
public class PmsBaseAttrValueImpl implements PmsBaseAttrValueService {

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(Long id) {
        PmsBaseAttrValue pmsBaseAttrValue = PmsBaseAttrValue.builder().attrId(id).build();
        return pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
    }
}
