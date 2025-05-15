package com.cruiser.students.Util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StandardResponse {
    private int Code;
    private String message;
    private Object data;
}
