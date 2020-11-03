package SqlCrudDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCrud {

	public static ArrayList<Student> readStudents() {
		ArrayList<Student> stu = new ArrayList<>();
		try {
			String sql = "SELECT * FROM students";
			Connection conn = SqlUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String name = rs.getString("name");
				String sec = rs.getString("section");
				float gpa = rs.getFloat("gpa");
				Student s = new Student();
				s.setStudentID(id);
				s.setName(name);
				s.setSection(sec);
				s.setGpa(gpa);
				stu.add(s);
			}
			System.out.println("Query executed successfully");
		} catch (SQLException ex) {
			Logger.getLogger(SqlCrud.class.getName()).log(Level.SEVERE, null, ex);
		}
		return stu;
	}

	public static void insertStudent(Student s) {
		try {
			String sql = "INSERT INTO students (studentId, name, section, gpa) VALUES (?,?,?,?)";
			Connection conn = SqlUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getStudentID());
			ps.setString(2, s.getName());
			ps.setString(3, s.getSection());
			ps.setFloat(4, s.getGpa());
			ps.executeUpdate();
			System.out.println("Query executed successfully");
		} catch (SQLException ex) {
			Logger.getLogger(SqlCrud.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void deleteStudent(int studId) {
		try {
			String sql = "DELETE FROM students " + "WHERE studentId = '" + studId + "'";
			Connection conn = SqlUtil.getConn();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Query executed successfully");
		} catch (SQLException ex) {
			Logger.getLogger(SqlCrud.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void updateStudent(Student s) {
		try {
			String sql = "UPDATE students SET name=?, section=?, gpa=? WHERE studentId=?";
			Connection conn = SqlUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getSection());
			ps.setFloat(3, s.getGpa());
			ps.setInt(4, s.getStudentID());
			ps.executeUpdate();
			System.out.println("Query executed successfully");
		} catch (SQLException ex) {
			Logger.getLogger(SqlCrud.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
