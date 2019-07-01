package com.test.service;


import com.test.dao.StudentDao;
import com.test.entity.StudentinfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     *获取所有学生
     * @author hjn
     * @date 2019/6/13
     * @param
     * @return java.util.List<com.test.entity.StudentinfoEntity>
     */
    public List<StudentinfoEntity> getAllStudent() {
        return studentDao.getAllStudent();
    }

    /**
     *根据name获取指定学生
     * @author hjn
     * @date 2019/6/13
     * @param
     * @return com.test.entity.StudentinfoEntity
     */
    public List<StudentinfoEntity> getStudentByName(String name){
        if (name == null || name == ""){
            return studentDao.getAllStudent();
        }else{
            return studentDao.getStudentByName(name);
        }
    }

    /**
     *根据id获取指定学生
     * @author hjn
     * @date 2019/6/13
     * @param id
     * @return com.test.entity.StudentinfoEntity
     */
    public StudentinfoEntity getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    /**
     *新增学生
     * @author hjn
     * @date 2019/6/13
     * @param studentinfoEntity
     * @return void
     */
    @Transactional
    public void addStudent(StudentinfoEntity studentinfoEntity){
        studentDao.addStudent(studentinfoEntity);
    }

    /**
     *根据id删除指定学生
     * @author hjn
     * @date 2019/6/13
     * @param id
     * @return boolean
     */
    @Transactional
    public boolean delStudentById(int id){
        return studentDao.delStudentById(id);
    }

    /**
     *更新学生信息
     * @author hjn
     * @date 2019/6/13
     * @param studentinfoEntity
     * @return boolean
     */
    @Transactional
    public boolean updateStudent(StudentinfoEntity studentinfoEntity){
        return studentDao.updateStudent(studentinfoEntity);
    }
}
