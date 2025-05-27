package ra.session_12.repository;

import ra.session_12.model.Student;

import java.util.List;

public interface StudentRep {
    List<Student> findAll();
    Student findById(int id);
    boolean save(Student student);
    boolean update(Student student);
    boolean delete(int studentId);
}
