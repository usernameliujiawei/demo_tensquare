package com.tensquare.recruit.qa.dao;

import com.tensquare.recruit.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 问题 数据访问接口
 */
public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    /**
     * nativeQuery=true  表示使用原生的sql语句，若不写或等于false表名则需对应实体类名，字段也必须是实体类的字段
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid=? ORDER BY replytime DESC", nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid=? ORDER BY reply DESC", nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    @Query(value = "SELECT * FROM tb_problem, tb_pl WHERE id = problemid AND labelid=? AND reply=0 ORDER BY createtime DESC", nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);

}
