package com.cruiser.students.DTO.Response;

import com.cruiser.students.Entity.Student;

import java.util.Date;

public record StudentResponseDTO(
        String id,
        String name,
        Date DOB,
        double average
) { }

