package com.test.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.io.Serializable;
import java.util.List;

public final class HibernateUtils {
    private static SessionFactory factory;

    public static Session getSession(){
        return factory.openSession();
    }

    public HibernateUtils(){//单例模式
    }

    static{
        //载入虚拟机时执行一些
        //configure默认加载hibernate.cfg.xml
        //如果不是hibernate.cfg.xml，则指定其他名字，此文件从classpath找
        //1、获取加载配置管理类，不给参数就默认加载hibernate.cfg.xml文件
        Configuration config = new Configuration().configure();
        //2、创建Session工厂对象
        factory = config.buildSessionFactory();
    }

    public static void add(Object obj){
        Session session = null;
        Transaction tx = null;
        try{
            //3、得到Session对象
            session = HibernateUtils.getSession();
            //4、使用Hibernate操作数据库，都要开启事务,得到事务对象
            tx = session.beginTransaction();
            //5、把对象添加到数据库中
            session.save(obj);
            //6、提交事务
            tx.commit();

        }catch (HibernateException e){
            if (tx != null){//如果存在失误，则回滚
                tx.rollback();
            }
        }finally{
            if (session != null){//如果session存在，则关闭
                session.close();
            }
        }
    }

    public static void update(Object obj){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) { // 如果存在事务，则回滚
                tx.rollback();
            }
            throw e; // 抛出异常
        } finally {
            if (session != null) // 如果session存在，则关闭
                session.close();
        }
    }

    public static void delete(Object obj){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) { // 如果存在事务，则回滚
                tx.rollback();
            }
            throw e; // 抛出异常
        } finally {
            if (session != null) // 如果session存在，则关闭
                session.close();
        }
    }

    public static Object get(Class clazz, Serializable id) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            Object obj = session.get(clazz, id);
            return obj;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Object> getAll(String hql) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            List list = null;
            Query query = session.createQuery(hql);
            list = query.list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static List<Object> getByName(String hql, String name) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            List list = null;
            Query query = session.createQuery(hql);
            query.setString(0, name);
            list = query.list();
            return list;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
