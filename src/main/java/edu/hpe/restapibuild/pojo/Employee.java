package edu.hpe.restapibuild.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}
