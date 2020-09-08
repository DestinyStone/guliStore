package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsProductSaleAttr;
import bean.PmsProductSaleAttrValue;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductSaleAttrMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductSaleAttrValueMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuSaleAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsProductSaleAttrService;

import java.util.List;

@Service
public class PmsProductSaleAttrServiceImpl implements PmsProductSaleAttrService {

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrList(Long spuId) {
        PmsProductSaleAttr pmsProductSaleAttr = PmsProductSaleAttr.builder().productId(spuId).build();
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.select(pmsProductSaleAttr);

        pmsProductSaleAttrList.stream().forEach(x -> {
            PmsProductSaleAttrValue pmsProductSaleAttrValueQuery = PmsProductSaleAttrValue.builder().productId(spuId).saleAttrId(x.getSaleAttrId()).build();
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.select(pmsProductSaleAttrValueQuery);
            x.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        });
        return pmsProductSaleAttrList;
    }

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrAndAllList(Long skuId) {
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.selectBySkuId(skuId);

        return pmsProductSaleAttrList;
    }

}
