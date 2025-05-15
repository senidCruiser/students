package com.cruiser.students.DTO.Mapper;

import com.cruiser.students.DTO.Request.StudentCreationRequestDTO;
import com.cruiser.students.Entity.Student;

public class StudentMapper {

    public static Student DataToStudent(StudentCreationRequestDTO studentCreationRequestDTO){

        return Student.builder().
                name(studentCreationRequestDTO.name()).
                DOB(studentCreationRequestDTO.DOB()).
                average(studentCreationRequestDTO.average()).
                build();
    }


}
