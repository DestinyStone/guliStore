package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsProductImage;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsProductImageMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import service.PmsProductImageService;

import java.util.List;

@Service
public class PmsProductImageServiceImpl implements PmsProductImageService {

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Override
    public List<PmsProductImage> selectSpuImageListBySpuId(Long spuId) {
        PmsProductImage pmsProductImage = PmsProductImage.builder().productId(spuId).build();
        return pmsProductImageMapper.select(pmsProductImage);
    }
}
