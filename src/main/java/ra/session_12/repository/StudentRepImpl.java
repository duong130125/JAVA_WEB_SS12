package ra.session_12.repository;

import org.springframework.stereotype.Repository;
import ra.session_12.model.Student;

import java.util.List;

@Repository
public class StudentRepImpl implements StudentRep {
    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public boolean save(Student student) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int studentId) {
        return false;
    }
}
