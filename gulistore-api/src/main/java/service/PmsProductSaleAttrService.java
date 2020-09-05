package service;

import bean.PmsProductSaleAttr;

import java.util.List;

public interface PmsProductSaleAttrService {
    List<PmsProductSaleAttr> getSpuSaleAttrList(Long spuId);
}
