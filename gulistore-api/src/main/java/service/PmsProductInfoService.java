package service;

import bean.PmsProductInfo;

import java.util.List;

public interface PmsProductInfoService {
    List<PmsProductInfo> getProductInfoListByCatalog3Id(Long id);

    String insertProductInfo(PmsProductInfo pmsProductInfo);
}
