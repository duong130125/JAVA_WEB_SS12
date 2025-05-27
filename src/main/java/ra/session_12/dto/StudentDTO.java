package ra.session_12.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class StudentDTO {
    private int id;
    @NotBlank(message = "Tên sinh viên không được để trống")
    private String name;
    @NotBlank(message = "Email không được để trống")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Định dạng email không hợp lệ")
    private String email;
    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải ngày quá khứ!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
}
