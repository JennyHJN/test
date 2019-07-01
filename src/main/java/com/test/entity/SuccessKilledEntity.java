package com.test.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "success_killed", schema = "test", catalog = "")
@IdClass(SuccessKilledEntityPK.class)
public class SuccessKilledEntity {
    private long seckillId;
    private long userPhone;
    private byte state;
    private Timestamp createTime;

    @Id
    @Column(name = "seckill_id")
    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    @Id
    @Column(name = "user_phone")
    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuccessKilledEntity that = (SuccessKilledEntity) o;

        if (seckillId != that.seckillId) return false;
        if (userPhone != that.userPhone) return false;
        if (state != that.state) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seckillId ^ (seckillId >>> 32));
        result = 31 * result + (int) (userPhone ^ (userPhone >>> 32));
        result = 31 * result + (int) state;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
