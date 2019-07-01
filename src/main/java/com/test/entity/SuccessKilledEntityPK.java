package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SuccessKilledEntityPK implements Serializable {
    private long seckillId;
    private long userPhone;

    @Column(name = "seckill_id")
    @Id
    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    @Column(name = "user_phone")
    @Id
    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuccessKilledEntityPK that = (SuccessKilledEntityPK) o;

        if (seckillId != that.seckillId) return false;
        if (userPhone != that.userPhone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (seckillId ^ (seckillId >>> 32));
        result = 31 * result + (int) (userPhone ^ (userPhone >>> 32));
        return result;
    }
}
