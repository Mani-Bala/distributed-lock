package com.spring.lock.dao;

import com.spring.lock.model.Datas;

public interface DataDAO {

    Datas findById(int id);

    void updateDatas(Datas datas);
}
