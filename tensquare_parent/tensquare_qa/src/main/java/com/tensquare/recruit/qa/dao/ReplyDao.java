package com.tensquare.recruit.qa.dao;

import com.tensquare.recruit.qa.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 回答数据访问接口
 */
public interface ReplyDao extends JpaRepository<Reply,String>, JpaSpecificationExecutor<Reply> {

}
