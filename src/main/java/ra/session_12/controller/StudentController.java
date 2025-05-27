package ra.session_12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ra.session_12.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
}
