package com.test.dao;

import com.test.entity.StudentinfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao{

    public StudentinfoEntity getStudentById(int id) {
        return (StudentinfoEntity) HibernateUtils.get(StudentinfoEntity.class, id);
    }

    public List<StudentinfoEntity> getStudentByName(String name) {
        String hql = "from StudentinfoEntity where name = ?";
        List studentGetByName = HibernateUtils.getByName(hql, name);
        return studentGetByName;
    }

    public List<StudentinfoEntity> getAllStudent() {
        String hql = "from StudentinfoEntity";
        List studentAll = HibernateUtils.getAll(hql);
        return studentAll;
    }

    public boolean delStudentById(int id){
        StudentinfoEntity studentinfoEntity = (StudentinfoEntity) HibernateUtils.get(StudentinfoEntity.class, id);
        HibernateUtils.delete(studentinfoEntity);
        return true;
    }

    public boolean delStudent(StudentinfoEntity studentinfoEntity) {
        HibernateUtils.delete(studentinfoEntity);
        return true;
    }

    public boolean updateStudent(StudentinfoEntity studentinfoEntity) {
        HibernateUtils.update(studentinfoEntity);
        return true;
    }
    public void addStudent(StudentinfoEntity studentinfoEntity) {
        HibernateUtils.add(studentinfoEntity);
    }
}