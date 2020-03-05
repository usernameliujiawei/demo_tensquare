package com.tensquare.recruit.base.service;

import com.tensquare.recruit.base.dao.LabelDao;
import com.tensquare.recruit.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 多条件查询
     * @param label
     * @return
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                /**
                 * new一个新list存放所有条件
                 */
                ArrayList<Predicate> list = new ArrayList<>();
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(label.getStatu()!=null && !"".equals(label.getStatu())){
                    Predicate predicate = cb.equal(root.get("state").as(String.class), "%" + label.getStatu() + "%");
                    list.add(predicate);
                }
                /**
                 * new一个数组作为最终返回值
                 */
                Predicate[] parr = new Predicate[list.size()];
                /**
                 * 把list转为数组
                 */
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        });
    }

    /**
     * 多条件分页查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    public Page<Label> pageQuery(Label label, int page, int size) {
        //封装分页对象
        Pageable pageable = PageRequest.of(page, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root  根对象，条件封装到哪个对象
             * @param query   封装查询关键字，如：group by，order by等
             * @param cb    用来封装对象，若返回null，表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname()!=null && !"".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");// labelname like "%小明%"
                    list.add(predicate);
                }
                if(label.getStatu()!=null && !"".equals(label.getStatu())){
                    Predicate predicate = cb.equal(root.get("statu").as(String.class), label.getStatu());// state = "1"
                    list.add(predicate);
                }
                //new一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                //把list直接转成数组
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        },pageable);
    }
}
