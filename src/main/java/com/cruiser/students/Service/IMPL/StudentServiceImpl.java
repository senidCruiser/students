package com.cruiser.students.Service.IMPL;

import com.cruiser.students.DTO.Mapper.StudentMapper;
import com.cruiser.students.DTO.Request.IdBasedRequestDTO;
import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.OneStudentResponseDTO;
import com.cruiser.students.DTO.Response.StudentPackResponseDTO;
import com.cruiser.students.Entity.Student;
import com.cruiser.students.Exception.ResourceNotFoundException;
import com.cruiser.students.Repo.StudentRepository;
import com.cruiser.students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentPackResponseDTO getAllStudents() {
        return new StudentPackResponseDTO(studentRepository.findAll());
    }

    @Override
    public OneStudentResponseDTO findStudent(IdBasedRequestDTO idBasedRequestDTO) {

        Student student = studentRepository.findById(idBasedRequestDTO.id()).orElseThrow(() ->
                new ResourceNotFoundException("Student not found with id " + idBasedRequestDTO.id()));

        return new OneStudentResponseDTO(student);
    }

    @Override
    public OneStudentResponseDTO saveStudent(StudentCreationRequestDTO studentCreationRequestDTO) {

        return new OneStudentResponseDTO(studentRepository.save(StudentMapper.DataToStudent(studentCreationRequestDTO)));
    }

    @Override
    public void deleteStudent(IdBasedRequestDTO idBasedRequestDTO) {
        studentRepository.deleteById(idBasedRequestDTO.id());
    }


}
