package ra.session_12.repository;

import org.springframework.stereotype.Repository;
import ra.session_12.model.Student;
import ra.session_12.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepImpl implements StudentRep {
    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> students = new ArrayList<>();

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_students()}");
            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return students;
    }


    @Override
    public Student findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_student_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return student;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call insert_student(?, ?, ?)}");
            callSt.setString(1, student.getName());
            callSt.setString(2, student.getEmail());
            callSt.setDate(3, (Date) student.getDob());

            result = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?, ?, ?, ?)}");
            callSt.setInt(1, student.getId());
            callSt.setString(2, student.getName());
            callSt.setString(3, student.getEmail());
            callSt.setDate(4, (Date) student.getDob());

            result = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;
    }

    @Override
    public boolean delete(int studentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, studentId);

            result = callSt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }

        return result;
    }

}
