package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st) {

		boolean f = false;
		try {
			Connection con = CP.creatC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?) ";

			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
         return f;
	}

	
	public static boolean deleteStudent(int userId) {
		boolean f = false;
		try {
			Connection con = CP.creatC();
			String q = "delete from students where sid = ?";

			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, userId );
			

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
         return f;
		
	}


   	public static void showAllStudent() {
		
		try {
			Connection con = CP.creatC();
			String q = "select * from students; ";

		    Statement pstmt =con.createStatement();
		    ResultSet set =pstmt.executeQuery(q);
		    
           while (set.next()) {
        	    int id = set.getInt(1);
        	    String name = set.getString(2);
        	    String phone = set.getString(3);
        	    String city = set.getString(3);
        	    
        	    System.out.println("ID : " + id);
        	    System.out.println("Name : " + name );
        	    System.out.println("Phone : " + phone);
        	    System.out.println("City : " + city);
        	    System.out.println("+++++++++++++++++++++++");
           }
		

		} catch (Exception e) {
			e.printStackTrace();
		}
       
		
	}
 
   	public static boolean modifyStudent (Student stu) {
   		boolean f = false;
		try {
			Connection con = CP.creatC();
			String q = "update students set sname = ?,sphone=?,scity=? where sid = ? ";

			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, stu.getStudentName());
			pstmt.setString(2, stu.getStudentPhone());
			pstmt.setString(3, stu.getStudentCity());
			pstmt.setInt(4, stu.getStudentId());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
         return f;
   	}
}
