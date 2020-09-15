package service;

import bean.PmsSearchParam;
import esbean.PmsSkuInfoSearch;

import java.util.List;

public interface PmsSkuInfoSearchService {
    List<PmsSkuInfoSearch> select(PmsSearchParam keyword);
}
