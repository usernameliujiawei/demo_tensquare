package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 * JpaRepository-->
 *          对继承父接口中方法的返回值进行了适配,因为在父类接口中通常都返回迭代器，需要我们自己进行强制类型转化。
 *          而在JpaRepository中，直接返回了List
 * JpaSpecificationExecutor-->
 *          提供了多条件查询的支持，并且可以在查询中添加分页和排序
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 查询前六位指定状态对象并按创建日期倒序
     * 作用等同于 where state=? order by createime
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 查询前六位非指定状态对象并按创建日期倒序
     *用等同于 where state!=? order by createime
     * @param state
     * @return
     */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
