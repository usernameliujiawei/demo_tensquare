package com.tensquare.recruit.article.dao;

import com.tensquare.recruit.article.pojo.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 专栏 数据访问接口
 */
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column> {
}
