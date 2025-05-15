package com.cruiser.students.Service;

import com.cruiser.students.DTO.Request.IdBasedRequestDTO;
import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.OneStudentResponseDTO;
import com.cruiser.students.DTO.Response.StudentPackResponseDTO;

public interface StudentService {


    StudentPackResponseDTO getAllStudents();

    OneStudentResponseDTO findStudent(IdBasedRequestDTO idBasedRequestDTO);

    OneStudentResponseDTO saveStudent(StudentCreationRequestDTO studentCreationRequestDTO);

    void deleteStudent(IdBasedRequestDTO idBasedRequestDTO);
}
