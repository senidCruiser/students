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
import org.springframework.web.bind.annotation.*;

@RestController("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAllStudents(){

        StudentPackResponseDTO students = studentService.getAllStudents();

        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", students),
                HttpStatus.OK
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        OneStudentResponseDTO oneStudentResponseDTO = studentService.findStudent(new IdBasedRequestDTO(id));
        return new ResponseEntity<>(
                new StandardResponse(200, "acknowledged", oneStudentResponseDTO),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createStudent(@RequestBody StudentCreationRequestDTO studentCreationRequestDTO){

        OneStudentResponseDTO oneStudentResponseDTO = studentService.saveStudent(studentCreationRequestDTO);

        return new ResponseEntity<>(
                new StandardResponse(201, "acknowledged", oneStudentResponseDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable String id){

        studentService.deleteStudent(new IdBasedRequestDTO(id));

        return new ResponseEntity<>(
                StandardResponse.builder().Code(204).message("acknowledged").build(),
                HttpStatus.OK
        );
    }



}
