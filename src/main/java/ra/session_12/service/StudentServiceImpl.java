package ra.session_12.service;

import org.springframework.stereotype.Service;
import ra.session_12.model.Student;
import ra.session_12.repository.StudentRep;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRep studentRepo;

    public StudentServiceImpl(StudentRep studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public boolean save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentRepo.update(student);
    }

    @Override
    public boolean delete(int studentId) {
        return studentRepo.delete(studentId);
    }
}
