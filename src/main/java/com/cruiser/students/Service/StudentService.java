package com.cruiser.students.Service;

import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.StudentResponseDTO;
import com.cruiser.students.DTO.Response.StudentPackResponseDTO;

import java.util.List;

public interface StudentService {


    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO findStudent(String id);

    StudentResponseDTO saveStudent(StudentCreationRequestDTO studentCreationRequestDTO);

    void deleteStudent(String id);
}
