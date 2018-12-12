package com.base.library.database;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by yg on 2018/12/11.
 */

public class DBBean extends DataSupport{

    @Column(ignore = true)
    public int itemtype;

    private String dbId;
    private String dbName;

    public int getItemtype() {
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
