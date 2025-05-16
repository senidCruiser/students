package com.cruiser.students.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "students")
public class Student {

    @Id
    private String id;
    private String name;
    private Date DOB;
    private double average;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                ", average=" + average +
                '}';
    }
}
