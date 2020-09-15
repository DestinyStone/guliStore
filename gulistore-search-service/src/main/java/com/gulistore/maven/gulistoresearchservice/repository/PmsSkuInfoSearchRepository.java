package com.gulistore.maven.gulistoresearchservice.repository;

import esbean.PmsSkuInfoSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmsSkuInfoSearchRepository extends ElasticsearchRepository<PmsSkuInfoSearch, Long> {
}
