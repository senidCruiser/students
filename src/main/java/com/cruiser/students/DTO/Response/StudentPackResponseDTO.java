package com.cruiser.students.DTO.Response;

import com.cruiser.students.Entity.Student;

import java.util.ArrayList;
import java.util.List;

public record StudentPackResponseDTO(List<Student> students) {
}
