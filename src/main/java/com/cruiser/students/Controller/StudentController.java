package com.cruiser.students.Controller;


import com.cruiser.students.DTO.Request.IdBasedRequestDTO;
import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.OneStudentResponseDTO;
import com.cruiser.students.DTO.Response.StudentPackResponseDTO;
import com.cruiser.students.Service.StudentService;
import com.cruiser.students.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAllStudents(){

        StudentPackResponseDTO students = studentService.getAllStudents();

        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", students),
                HttpStatus.OK
        );
    }

    @PostMapping("/byId")
    public ResponseEntity<StandardResponse> getById(@RequestBody IdBasedRequestDTO idBasedRequestDTO){
        OneStudentResponseDTO oneStudentResponseDTO = studentService.findStudent(idBasedRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", oneStudentResponseDTO),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createStudent(@RequestBody StudentCreationRequestDTO studentCreationRequestDTO){

        OneStudentResponseDTO oneStudentResponseDTO = studentService.saveStudent(studentCreationRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", oneStudentResponseDTO),
                HttpStatus.OK
        );
    }

    @PostMapping("/delete")
    public ResponseEntity<StandardResponse> deleteStudent(){

        return new ResponseEntity<>(
                StandardResponse.builder().Code(200).message("acknowledged").build(),
                HttpStatus.OK
        );
    }



}
