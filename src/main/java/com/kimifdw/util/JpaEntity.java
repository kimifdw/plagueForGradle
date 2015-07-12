package com.kimifdw.util;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 所有model类的基类
 * Created by kimiyu on 15/7/11.
 */
@MappedSuperclass
public abstract class JpaEntity<T> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String creater;
    @Column(nullable = false)
    private Date createDate = new Date();
    @Column
    private String updater;
    @Column
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
