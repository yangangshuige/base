package com.base.library.database;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public class DBDao {

    /**
     * 获取所有频道
     *
     * @return
     */
    public static List<DBBean> getDBBeans() {
        return DataSupport.findAll(DBBean.class);
    }


    /**
     * 保存所有频道
     *
     * @param mDBBeans
     */
    public static void saveDBBeans(final List<DBBean> mDBBeans) {
        if (mDBBeans == null) return;
        if (mDBBeans.size() > 0) {
            final List<DBBean> dbBeanList = new ArrayList<>();
            dbBeanList.addAll(mDBBeans);
            DataSupport.deleteAllAsync(DBBean.class).listen(new UpdateOrDeleteCallback() {
                @Override
                public void onFinish(int rowsAffected) {
                    /**
                     * 因为model之前被存储过了，再次存储就存不进去了。
                     * 单个model调用一下clearSavedState方法就可以了，
                     * 集合的话调用markAsDeleted方法。
                     */
                    DataSupport.markAsDeleted(dbBeanList);
                    DataSupport.saveAllAsync(dbBeanList).listen(new SaveCallback() {
                        @Override
                        public void onFinish(boolean success) {

                        }
                    });
                }
            });
        }
    }

    /**
     * 清空所有频道
     */
    public static void cleanDBBeans() {
        DataSupport.deleteAll(DBBean.class);
    }
}
