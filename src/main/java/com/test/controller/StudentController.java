package com.test.controller;

import com.test.entity.StudentinfoEntity;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller //注释表明一个特定类是一个控制器的作用
@RequestMapping("/student")//根路径，Contoller下所有接口统一入口，注释用于映射 URL 到整个类或一个特定的处理方法
public class StudentController {

    @Autowired // 以类型的方式注入(Spring有多种方式实现自动注入，但按类型注入更简单清晰)
    private StudentService studentService;

    @RequestMapping("/getAllStudent")
    public String getAllStudent(HttpServletRequest request){
        List<StudentinfoEntity> studentList = studentService.getAllStudent();
        request.setAttribute("studentList", studentList);
        return "student/index";
    }

    @RequestMapping("/getStudent")
    public String getStudentById(@RequestParam(value = "id") int id, HttpServletRequest request){
        StudentinfoEntity student = studentService.getStudentById(id);
        request.setAttribute("student", student);
        return "student/editStudent";
    }

    @RequestMapping("/getStudentREST")
    public String getStudentRESTById(@RequestParam(value = "id") int id, HttpServletRequest request){
        StudentinfoEntity student = studentService.getStudentById(id);
        request.setAttribute("student", student);
        return "studentREST/editStudent";
    }

    @RequestMapping("/getStudentByName")
    public String getStudentByName(@RequestParam(value = "name") String name, HttpServletRequest request){
        List<StudentinfoEntity> studentinByNameList = studentService.getStudentByName(name);

        request.setAttribute("studentList", studentinByNameList);
        return "student/index";
    }

    @RequestMapping("/toAddStudent")
    public String toAddStudent(){
        return "student/addStudent";
    }

    @RequestMapping("/toAddStudentREST")
    public String toAddStudentREST(){
        return "studentREST/addStudent";
    }
    @RequestMapping("/addStudent")
    public String addStudent(StudentinfoEntity student, HttpServletRequest request){
        studentService.addStudent(student);
        return "redirect:getAllStudent";
    }

    @RequestMapping("/delStudent")
    public void delStudentById(@RequestParam(value = "id") int id, HttpServletResponse response){
        String result = "{\"result\":\"error\"}";
        if(studentService.delStudentById(id)){
            result = "{\"result\":\"success\"}";
        }
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(StudentinfoEntity student, HttpServletRequest request){

        if(studentService.updateStudent(student)){
            student = studentService.getStudentById(student.getId());
            request.setAttribute("student", student);
            return "redirect:getAllStudent";
        }else{
            return "student/error";
        }
    }

}