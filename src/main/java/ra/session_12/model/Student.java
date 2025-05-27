package ra.session_12.model;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private int id;
    private String name;
    private String email;
    private Date dob;
}
