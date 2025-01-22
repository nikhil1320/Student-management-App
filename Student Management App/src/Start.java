import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Student management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("Press 1 to Add Student ");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display student ");
			System.out.println("Press 4 to Modify Entry");
			System.out.println("Press 5 to Exit");

			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				System.out.println("Enter User Name :");
				String name = br.readLine();
				
				System.out.println("Enter User Phone");
				String phone = br.readLine();
				
				System.out.println("Enter User city");
				String city = br.readLine(); 
				
				Student st = new Student(name, phone, city);
				boolean answer =StudentDao.insertStudentToDB(st);
				if(answer == true) {
					System.out.println("Student added successfully");
				}else {
					System.out.println("Something went wrong");
				}
				System.out.println(st);
				

			} else if (c == 2) {
				System.out.println("Enter Student ID to delete");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				if(f==true) {
					System.out.println("Deleted");
				}else {
					System.out.println("Something went wrong");
				}

			} else if (c == 3) {
				StudentDao.showAllStudent();

			} else if (c == 4) {
				
				System.out.println("Enter User Name : ");
				String Name = br.readLine();
				
				System.out.println("Enter User Phone : ");
				String Phone = br.readLine();
				
				System.out.println("Enter User City : ");
				String City = br.readLine();
				
				System.out.println("Enter userId to modify : ");
				int Id = Integer.parseInt(br.readLine());
				
				Student stu =new Student(Id, Name, Phone, City);
				boolean M = StudentDao.modifyStudent(stu);
				if(M == true) {
					System.out.println("Data edited successfully");
				}else {
					System.out.println("Something went wrong");
				}
				
			} else if (c==5){
               break;
			}else {
				
			}

		}
		System.out.println("Thank you for using our App");

	}

}
