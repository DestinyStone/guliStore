package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsProductInfo;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductImageMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductInfoMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductSaleAttrMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductSaleAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsProductInfoService;

import java.util.List;

@Service
public class PmsProductInfoServiceImpl implements PmsProductInfoService {

    @Autowired
    private PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> getProductInfoListByCatalog3Id(Long id) {
        PmsProductInfo pmsProductInfo = PmsProductInfo.builder().catalog3Id(id).build();
        return pmsProductInfoMapper.select(pmsProductInfo);
    }

    @Override
    public String insertProductInfo(PmsProductInfo pmsProductInfo) {
        try {
            pmsProductInfoMapper.insertSelective(pmsProductInfo);
            pmsProductInfo.getSpuImageList().stream().forEach(x -> x.setProductId(pmsProductInfo.getId()));
            pmsProductImageMapper.insertList(pmsProductInfo.getSpuImageList());

            pmsProductInfo.getSpuSaleAttrList().stream().forEach(x -> x.setProductId(pmsProductInfo.getId()));
            pmsProductSaleAttrMapper.insertList(pmsProductInfo.getSpuSaleAttrList());

            pmsProductInfo.getSpuSaleAttrList().stream().forEach(x -> {
                x.getSpuSaleAttrValueList().stream().forEach(spuAttrValueList -> spuAttrValueList.setProductId(pmsProductInfo.getId()));
                pmsProductSaleAttrValueMapper.insertList(x.getSpuSaleAttrValueList());
            });
            return "true";
        } catch (Exception e) {

        }
       return "fasle";
    }
}
