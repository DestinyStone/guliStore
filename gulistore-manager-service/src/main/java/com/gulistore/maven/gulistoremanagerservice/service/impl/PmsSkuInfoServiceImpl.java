package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsSkuInfo;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuImageMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuInfoMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuSaleAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsSkuInfoService;

@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public String insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo) {
        try {
            pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
            pmsSkuInfo.getSkuImageList().stream().forEach(x -> x.setSkuId(pmsSkuInfo.getId()));
            pmsSkuImageMapper.insertList(pmsSkuInfo.getSkuImageList());

            pmsSkuInfo.getSkuSaleAttrValueList().stream().forEach(x -> {
                x.setSkuId(pmsSkuInfo.getId());
            });
            pmsSkuSaleAttrValueMapper.insertList(pmsSkuInfo.getSkuSaleAttrValueList());

            return "true";
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "false";

    }
}
