package ra.session_12.service;

import ra.session_12.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int studentId);
}
