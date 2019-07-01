package com.test.controller;

import com.test.entity.StudentinfoEntity;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRESTController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<StudentinfoEntity>> getAllStudent(){
        List<StudentinfoEntity> students = studentService.getAllStudent();
        if (students.isEmpty()){
            return new ResponseEntity<List<StudentinfoEntity>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<StudentinfoEntity>>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<StudentinfoEntity> getStudentById(@PathVariable("id") int id){
        System.out.println("Fetching Student with id " + id);
        StudentinfoEntity student = studentService.getStudentById(id);
        if (student == null){
            System.out.println("Student with id " + id + "not found");
            return new ResponseEntity<StudentinfoEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentinfoEntity>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<StudentinfoEntity>> getStudentByName(@PathVariable("name") String name){
        System.out.println("Fetching Student with name " + name);
        List<StudentinfoEntity> student = studentService.getStudentByName(name);
        if (student.isEmpty()){
            System.out.println("Student with name " + name + "not found");
            return new ResponseEntity<List<StudentinfoEntity>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<StudentinfoEntity>>(student, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
    public ResponseEntity<Void> addStudent(@RequestBody StudentinfoEntity student, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Student " + student.getName());

        studentService.addStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8")
    public ResponseEntity<StudentinfoEntity> updateStudent(@PathVariable("id") int id, @RequestBody StudentinfoEntity student){
        System.out.println("Updating Student " + id);

        StudentinfoEntity currentStudent = studentService.getStudentById(id);

        if (currentStudent == null){
            System.out.println("Student with id " + id + "not found");
            return new ResponseEntity<StudentinfoEntity>(HttpStatus.NOT_FOUND);
        }

        currentStudent.setName(student.getName());
        currentStudent.setPassword(student.getPassword());
        currentStudent.setAge(student.getAge());
        currentStudent.setAddress(student.getAddress());

        studentService.updateStudent(currentStudent);
        return new ResponseEntity<StudentinfoEntity>(currentStudent, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<StudentinfoEntity> delStudentById(@PathVariable("id") int id){
        System.out.println("Fetching & Deleting Student with id " + id);

        StudentinfoEntity student = studentService.getStudentById((id));
        if (student == null){
            System.out.println("Unable to delete. Student with id " + id + " not found");
            return new ResponseEntity<StudentinfoEntity>(HttpStatus.NOT_FOUND);
        }
        studentService.delStudentById(id);
        return new ResponseEntity<StudentinfoEntity>(HttpStatus.NO_CONTENT);
    }

}
