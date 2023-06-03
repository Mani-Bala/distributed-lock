package com.spring.lock.service.impl;

import com.spring.lock.dao.DataDAO;
import com.spring.lock.model.Datas;
import com.spring.lock.service.LockService;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Service
@RequiredArgsConstructor
public class LockServiceImpl implements LockService {

    // If key is unique would be better.
    private static final String MY_LOCK_KEY = "someLockKey";
    private static final int TRY_LOCK_WAIT_MIN = 2;

    public final LockRegistry lockRegistry;

    public final DataDAO dataDAO;

    @Override
    public String lock() {
        String returnVal = null;
        var lock = lockRegistry.obtain(MY_LOCK_KEY);
        try {
            if (lock.tryLock(TRY_LOCK_WAIT_MIN, TimeUnit.MINUTES)) {
                returnVal =  "jdbc lock successful";

                int rowId = 3;
                Datas datas = dataDAO.findById(rowId);

                datas.setData(datas.getData() + 8);
                datas.setVersion(datas.getVersion() + 1);

                dataDAO.updateDatas(datas);

            } else {
                returnVal = "jdbc lock unsuccessful";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return returnVal;
    }
}
