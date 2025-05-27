package ra.session_12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.session_12.model.Student;
import ra.session_12.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Hiển thị danh sách sinh viên
    @GetMapping("list-student")
    public String findAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student_list";
    }

    // Hiển thị form thêm mới
    @GetMapping("add-student")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student_form";
    }

    // Xử lý thêm mới
    @PostMapping("add-student")
    public String doAdd(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/list-student";
    }

    // Hiển thị form sửa
    @GetMapping("edit-student/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student_form";
    }

    // Xử lý cập nhật
    @PostMapping("edit-student")
    public String doEdit(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/list-student";
    }

    // Xử lý xóa
    @GetMapping("delete-student/{id}")
    public String delete(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/list-student";
    }
}

