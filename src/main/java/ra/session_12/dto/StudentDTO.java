package ra.session_12.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class StudentDTO {
    private int id;
    @NotBlank(message = "Tên sinh viên không được để trống")
    private String name;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Định dạng email không hợp lệ")
    private String email;
    private Date dob;
}
