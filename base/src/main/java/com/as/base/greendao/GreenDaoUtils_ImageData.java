package com.as.base.greendao;


import com.as.base.application.BaseApplication;
import com.as.greendao.gen.Data_ImageDao;

import java.util.List;

/**
 * 操作 Data_Image 数据库的 工具类
 */

public class GreenDaoUtils_ImageData {
    /**
     * 添加数据，如果有重复则覆盖
     */
    public static void insertUserInfo(Data_Image userInfo) {
        BaseApplication.getDaoInstant().getData_ImageDao().insertOrReplace(userInfo);
    }

    /**
     * 删除数据
     */
    public static void deleteAllUserInfo() {
        BaseApplication.getDaoInstant().getData_ImageDao().deleteAll();
    }

    /**
     * 更新数据
     */
    public static void updateUserInfo(Data_Image userInfo) {
        BaseApplication.getDaoInstant().getData_ImageDao().update(userInfo);
    }

//    /**
//     * 查询条件为Type=TYPE_LOVE的数据
//     *
//     * @return
//     */
//    public static LocalMusic queryMusic(int uid) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Uid.eq(uid)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static Data_Image queryAll() {
        List<Data_Image> userInfos = BaseApplication.getDaoInstant().getData_ImageDao().loadAll();
        if (userInfos.size() == 0) {
            return null;
        }
        return userInfos.get(0);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
//    public static LocalMusic queryIdMusic(Long id) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Id.eq(id)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static int querySortId() {
        return BaseApplication.getDaoInstant().getData_ImageDao().queryBuilder().where(Data_ImageDao.Properties.Id.eq(1L)).uniqueOrThrow().getSortid();
    }
}
