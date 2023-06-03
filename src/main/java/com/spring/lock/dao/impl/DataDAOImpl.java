package com.spring.lock.dao.impl;

import com.spring.lock.dao.DataDAO;
import com.spring.lock.model.Datas;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;

import java.io.Serializable;

@Repository
public class DataDAOImpl implements DataDAO {
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

    @Override
    public Datas findById(final int id) {
        try{
            return entityManager.find(Datas.class, id);
        } catch (RuntimeException re) {
            System.out.println("findById failed " + re);
            throw re;
        }
    }

    @Override
    public void updateDatas(Datas datas) {
        System.out.println("save  instance");
        try{
            entityManager.persist(datas);
        }catch (RuntimeException re) {
            System.out.println("save failed" + re);
            throw re;
        }
    }
}
