package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsSkuAttrValue;
import bean.PmsSkuImage;
import bean.PmsSkuInfo;
import bean.PmsSkuSaleAttrValue;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuAttrValueMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuImageMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuInfoMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsSkuSaleAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsSkuInfoService;

import java.util.List;

@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Override
    public String insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo) {
        try {
            pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
            pmsSkuInfo.getSkuImageList().stream().forEach(x -> x.setSkuId(pmsSkuInfo.getId()));
            pmsSkuImageMapper.insertList(pmsSkuInfo.getSkuImageList());

            pmsSkuInfo.getSkuSaleAttrValueList().stream().forEach(x -> x.setSkuId(pmsSkuInfo.getId()));
            pmsSkuSaleAttrValueMapper.insertList(pmsSkuInfo.getSkuSaleAttrValueList());

            pmsSkuInfo.getSkuAttrValueList().forEach(x -> x.setSkuId(pmsSkuInfo.getId()));
            pmsSkuAttrValueMapper.insertList(pmsSkuInfo.getSkuAttrValueList());

            return "true";
        }catch (Exception e) {
            e.printStackTrace();
        }

        return "false";

    }

    @Override
    public PmsSkuInfo selectById(Long skuId) {
        PmsSkuInfo pmsSkuInfoQuery = PmsSkuInfo.builder().id(skuId).build();
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfoQuery);

        PmsSkuImage pmsSkuImage = PmsSkuImage.builder().skuId(skuId).build();
        List<PmsSkuImage> pmsSkuImageList = pmsSkuImageMapper.select(pmsSkuImage);

        PmsSkuSaleAttrValue pmsSkuSaleAttrValue = PmsSkuSaleAttrValue.builder().skuId(skuId).build();
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuSaleAttrValueMapper.select(pmsSkuSaleAttrValue);

        pmsSkuInfo.setSkuImageList(pmsSkuImageList);
        pmsSkuInfo.setSkuSaleAttrValueList(pmsSkuSaleAttrValueList);

        return pmsSkuInfo;
    }

    @Override
    public List<PmsSkuInfo> selectAll() {
        List<PmsSkuInfo> pmsSkuInfoList = pmsSkuInfoMapper.selectAll();
        pmsSkuInfoList.forEach(x -> {
            PmsSkuAttrValue pmsSkuAttrValueQuery = PmsSkuAttrValue.builder().skuId(x.getId()).build();
            List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuAttrValueMapper.select(pmsSkuAttrValueQuery);
            x.setSkuAttrValueList(pmsSkuAttrValueList);
        });
        return pmsSkuInfoList;
    }
}
