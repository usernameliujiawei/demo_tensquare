package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 企业数据访问接口层
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {

    /**
     *  查询是否热门数据集合
     * 作用等同于 where ishot = ?
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);

}
