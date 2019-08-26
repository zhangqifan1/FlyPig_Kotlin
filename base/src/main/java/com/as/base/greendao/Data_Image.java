package com.as.base.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

/**
 * -----------------------------
 * Created by zqf on 2018/4/27.
 * 当前用户的数据库
 * ---------------------------
 */
@Entity
public class Data_Image {

    //不能用int
    @Id(autoincrement = true)
    private Long id;

    private int sortid;

    private String imageUrl;

    @Generated(hash = 754532131)
    public Data_Image(Long id, int sortid, String imageUrl) {
        this.id = id;
        this.sortid = sortid;
        this.imageUrl = imageUrl;
    }

    /**
     * 使用Keep 关键字定义 自己的 构造方法
     */
    @Keep
    public Data_Image(int sortid, String imageUrl) {
        this.sortid = sortid;
        this.imageUrl = imageUrl;
    }

    @Generated(hash = 1335187148)
    public Data_Image() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSortid() {
        return this.sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
