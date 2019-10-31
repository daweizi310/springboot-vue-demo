package com.maxton.service;

import com.maxton.common.exception.ExceptionCast;
import com.maxton.common.response.enumCode.CommonCode;
import com.maxton.dao.UserDataDao;
import com.maxton.model.UserData;
import com.maxton.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Description
 * @Author maxton.zhang
 * @Date 2019/10/31 13:10
 * @Version 1.0
 */
@Service
@Transactional
public class UserDataService {
    @Autowired
    private UserDataDao userDataDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有
     *
     * @return
     */
    public List<UserData> findAll() {
        return userDataDao.findAll();
    }

    /**
     * 根据id查询
     *
     * @param user_id
     * @return
     */
    public UserData findUserDataById(String user_id) {
        Optional<UserData> optional = userDataDao.findById(user_id);
        if (!optional.isPresent()) {
            ExceptionCast.cast(CommonCode.QUERY_ERROR); // 查询失败,抛异常
        }
        return optional.get();
    }


    /**
     * 条件查询+分页
     *
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<UserData> findSearch(Map whereMap, int page, int size) {
        Specification<UserData> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return userDataDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     *
     * @param whereMap
     * @return
     */
    public List<UserData> findSearch(Map whereMap) {
        Specification<UserData> specification = createSpecification(whereMap);
        return userDataDao.findAll(specification);
    }

    /**
     * 增加
     *
     * @param userData
     */
    public void add(UserData userData) {
        userData.setUser_id(idWorker.nextId() + "");
        userData.setCreate_time(new Date());
        userDataDao.save(userData);
    }

    /**
     * 修改
     *
     * @param userData
     */
    public void update(UserData userData) {
        userData.setCreate_time(new Date());
        userDataDao.save(userData);
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteById(String id) {
        userDataDao.deleteById(id);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<UserData> createSpecification(Map searchMap) {
        return new Specification<UserData>() {
            @Override
            public Predicate toPredicate(Root<UserData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // user_id
                if (searchMap.get("user_id") != null && !"".equals(searchMap.get("user_id"))) {
                    predicateList.add(cb.equal(root.get("user_id").as(String.class), (String) searchMap.get("user_id")));
                }
                // name
                if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                    predicateList.add(cb.equal(root.get("name").as(String.class), (String) searchMap.get("name")));
                }
                // address
                if (searchMap.get("address") != null && !"".equals(searchMap.get("address"))) {
                    predicateList.add(cb.like(root.get("address").as(String.class), "%" + (String) searchMap.get("address") + "%"));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

    }
}
