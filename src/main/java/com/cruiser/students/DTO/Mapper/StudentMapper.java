package com.cruiser.students.DTO.Mapper;

import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.DTO.Response.StudentResponseDTO;
import com.cruiser.students.Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static Student studentCreationRequestDTOToStudent(StudentCreationRequestDTO studentCreationRequestDTO){

        return Student.builder().
                name(studentCreationRequestDTO.name()).
                DOB(studentCreationRequestDTO.DOB()).
                average(studentCreationRequestDTO.average()).
                build();
    }

    public static StudentResponseDTO studentToStudentResponseDTO(
            Student student
    ){

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getDOB(),
                student.getAverage()
        );
    }


    public static List<StudentResponseDTO> studentListToStudentResponseDTOList(List<Student> students){

        List<StudentResponseDTO> newStudentList = new  ArrayList<>();
        for(Student student: students) newStudentList.add(
                new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getDOB(),
                        student.getAverage()
                )
        );

        return newStudentList;
    }


}
