package com.cruiser.students.Service.IMPL;

import com.cruiser.students.DTO.Mapper.StudentMapper;
import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.StudentResponseDTO;
import com.cruiser.students.Entity.Student;
import com.cruiser.students.Exception.ResourceNotFoundException;
import com.cruiser.students.Repo.StudentRepository;
import com.cruiser.students.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        log.debug("send the list of student: {}", students);
        return StudentMapper.studentListToStudentResponseDTOList(students);
    }

    @Override
    public StudentResponseDTO findStudent(String id) {

        Student student = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student not found with id " + id));

        log.debug("retrieve student with id: {}",student.getId());

        return StudentMapper.studentToStudentResponseDTO(student);
    }

    @Override
    public StudentResponseDTO saveStudent(StudentCreationRequestDTO studentCreationRequestDTO) {

        Student savedstudent= studentRepository.save(StudentMapper.studentCreationRequestDTOToStudent(studentCreationRequestDTO));
        log.debug("Save student: {}", savedstudent);

        return StudentMapper.studentToStudentResponseDTO(savedstudent);
    }

    @Override
    public void deleteStudent(String id) {

        studentRepository.deleteById(id);
        log.debug("Student deletion complete");
    }


}
