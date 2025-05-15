package com.cruiser.students.DTO.Request;

import java.util.Date;

public record StudentCreationRequestDTO(
        String name,
        Date DOB,
        double average
) {}
