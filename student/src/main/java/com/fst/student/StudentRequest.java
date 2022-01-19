package com.fst.student;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String cin;
    private String phone;
}
