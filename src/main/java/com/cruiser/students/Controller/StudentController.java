package com.cruiser.students.Controller;


import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.StudentResponseDTO;
import com.cruiser.students.DTO.Response.StudentPackResponseDTO;
import com.cruiser.students.Service.StudentService;
import com.cruiser.students.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents(){
        log.info("Request on all students");
        List<StudentResponseDTO> students = studentService.getAllStudents();
        log.info("Send all students");
        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", students),
                HttpStatus.OK
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        log.info("Request on student: {}", id);
        StudentResponseDTO studentResponseDTO = studentService.findStudent(id);
        log.info("Send details on student: {}", id);
        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", studentResponseDTO),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createStudent(@RequestBody StudentCreationRequestDTO studentCreationRequestDTO){
        log.info(
                """
                   create student with,
                   name: {}
                   DOB: {}
                   percentage: {}
                """,
                studentCreationRequestDTO.name(),
                studentCreationRequestDTO.DOB().toString(),
                studentCreationRequestDTO.average()
        );
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(studentCreationRequestDTO);

        log.info(
                """
                   send confirmation of student creation,
                   id: {}
                   name: {}
                   DOB: {}
                   percentage: {}
                """,
                studentResponseDTO.id(),
                studentResponseDTO.name(),
                studentResponseDTO.DOB().toString(),
                studentResponseDTO.average()
        );

        return new ResponseEntity<>(
                new StandardResponse(201, "acknowledged", studentResponseDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String id){
        log.info("delete request with for the id: {}", id);
        studentService.deleteStudent(id);
        return new ResponseEntity<>(
                StandardResponse.builder().Code(204).message("acknowledged").build(),
                HttpStatus.OK
        );
    }



}
