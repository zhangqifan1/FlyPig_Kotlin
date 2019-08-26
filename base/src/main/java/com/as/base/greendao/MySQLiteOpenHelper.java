package com.as.base.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.as.greendao.gen.DaoMaster;
import com.as.greendao.gen.Data_ImageDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;
import org.greenrobot.greendao.database.Database;

/**
 * 一个管理类
 */
public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {

            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, Data_ImageDao.class);//可变数组
    }
}