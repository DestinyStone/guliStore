package service;

import bean.PmsProductImage;

import java.util.List;

public interface PmsProductImageService {
    List<PmsProductImage> selectSpuImageListBySpuId(Long spuId);
}
