package SqlCrudDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int id;
		Student s = new Student();
		ArrayList<Student> stu = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Executing SQL from Java");

		// create
		System.out.println("\nCreate operation.\nEnter student details (ID, name, section, grade): ");
		s.setStudentID(sc.nextInt());
		s.setName(sc.next());
		s.setSection(sc.next());
		s.setGpa(sc.nextFloat());
		SqlCrud.insertStudent(s);

		// read
		System.out.println("\nRead operation.\nStudent details (ID, name, section, grade): ");
		stu = SqlCrud.readStudents();
		for (Student st : stu) {
			System.out.println(st);
		}

		// update
		System.out.println("\nUpdate operation. \nEnter student ID and then new details (name, section, grade): ");
		s = new Student();
		s.setStudentID(sc.nextInt());
		s.setName(sc.next());
		s.setSection(sc.next());
		s.setGpa(sc.nextFloat());
		SqlCrud.updateStudent(s);

		// read
		System.out.println("\nRead operation.\nStudent details (ID, name, section, grade): ");
		stu = SqlCrud.readStudents();
		for (Student st : stu) {
			System.out.println(st);
		}

		// delete
		System.out.println("\nDelete operation. \nEnter student ID: ");
		id = sc.nextInt();
		SqlCrud.deleteStudent(id);

		// read
		System.out.println("\nRead operation.\nStudent details (ID, name, section, grade): ");
		stu = SqlCrud.readStudents();
		for (Student st : stu) {
			System.out.println(st);
		}
	}

}
