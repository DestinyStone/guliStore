package com.gulistore.maven.gulistoremanagerservice.service.impl;

import bean.PmsBaseAttrInfo;
import bean.PmsBaseAttrValue;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrInfoMapper;
import com.gulistore.maven.gulistoremanagerservice.mapper.PmsBaseAttrValueMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import service.PmsBaseAttrInfoService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class PmsBaseAttrInfoServiceImpl implements PmsBaseAttrInfoService {

    @Autowired
    private PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    private PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoListByCatalog3Id(Long Catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfoQuery = PmsBaseAttrInfo.builder().catalog3Id(Catalog3Id).build();
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfoQuery);
        pmsBaseAttrInfoList.stream().forEach(pmsBaseAttrInfo -> {
            PmsBaseAttrValue pmsBaseAttrValue = PmsBaseAttrValue.builder().attrId(pmsBaseAttrInfo.getId()).build();
            List<PmsBaseAttrValue> pmsBaseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            pmsBaseAttrInfo.setAttrValueList(pmsBaseAttrValueList);
        });

        return pmsBaseAttrInfoList;
    }

    @Override
    @Transactional
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        try {
            if (pmsBaseAttrInfo.getId() != null) {
                pmsBaseAttrInfoMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);

                Example example = new Example(PmsBaseAttrValue.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("attrId", pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.deleteByExample(example);
            } else {
                pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            }

            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrInfo.getAttrValueList()) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            }
            pmsBaseAttrValueMapper.insertList(pmsBaseAttrInfo.getAttrValueList());
            return "true";
        } catch (Exception e) {

        }
        return "error";
    }

    @Override
    public List<PmsBaseAttrInfo> selectByValueId(Long[] valueIds) {
        if (valueIds ==null) return null;
        List<PmsBaseAttrInfo> pmsBaseAttrInfoList = pmsBaseAttrInfoMapper.selectByValueIds(valueIds);
        return pmsBaseAttrInfoList;
    }
}
