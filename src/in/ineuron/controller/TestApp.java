package in.ineuron.controller;
import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;

import java.io.*;
import java.util.Scanner;
import in.ineuron.servicefactory.StudentServiceFactory;





public class TestApp {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Please Enter Your Choice:: [1/2/3/4/5] ");
			
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			
			String options = br.readLine(); 
			
			switch (options) {
			
			case "1": insertOperation();
				break;
				
			case "2": selectOperation();
				break;
				
			case "3": updateRecord();
		
				break;
			case "4": deleteOperation();
				
				break;
				
			case "5": System.out.println("Thank You for Using our Application");
				System.exit(0);
				
				break;

			default: System.out.println("Invalid Input. Please Try Again");
				break;
			}
			
		}
		
	}


	//Updating the Student Record::
	private static void updateRecord() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the sudent id to be updated:: ");
		String sid = br.readLine();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));
		
		if(student != null) {
			Student newstudent = new Student();
			//the student exist so process the logic::
			
			System.out.println("Student Id is:: " + student.getSid());
			newstudent.setSid(student.getSid());
			
			System.out.println("Student Old Name is:: " + student.getSname() + " Enter New Name:: ");
			String newName = br.readLine();
			if(newName.equals("") || newName == "") {
				newstudent.setSname(student.getSname());
			}
			else {				
				newstudent.setSname(newName);
			}
			
			System.out.println("Student Old Age is:: " + student.getSage() + " Enter New Age:: ");
			String newAge = br.readLine();
			if(newAge.equals("") || newAge == "") {
				newstudent.setSage(student.getSage());
			}
			else {				
				newstudent.setSage(Integer.parseInt(newAge));
			}
			
			
			System.out.println("Student Old Address is:: " + student.getSaddress() + " Enter New Address:: ");
			String newAddress = br.readLine();
			if(newAddress.equals("") || newAddress == "") {
				newstudent.setSaddress(student.getSaddress());
			}
			else {				
				newstudent.setSaddress(newAddress);
			}
			
			
			System.out.println("Updated Result is:: " + newstudent);
			
			String status = studentService.updateStudent(newstudent);
			if(status.equalsIgnoreCase("success")) {
				System.out.println("Record Updated Successfully...");
			}
			else {
				System.out.println("Record Updation Failed");
			}
			
		}
		
		else {
			System.out.println("Student with the id " +sid+" not in records.");
		}
	}

	
	
	
//	private static void updateOperation() {
//		//Updation::
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Tell the id of the student:: ");
//		int sid = scan.nextInt();
//		System.out.println("Tell the name of the student:: ");
//		String sname = scan.next();
//		System.out.println("Tell the age of the student:: ");
//		int sage = scan.nextInt();
//		System.out.println("Tell the address of the student:: ");
//		String sadd = scan.next();
//		
//		
//		IStudentService studentService = StudentServiceFactory.getStudentService();
//		String msg = studentService.updateStudent(sid, sname, sage, sadd);
//		
//		if(msg.equalsIgnoreCase("success")) {
//			System.out.println("Record Updated Successfully");
//		}
//		else {
//			System.out.println("Record didn't update");
//		}
//		
//		scan.close();
//		

//		Student std = TestApp.selectOperation();
//		System.out.println(std);
//		System.out.println("ID\tNAME\tAGE\tADDRESS");
//		System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
		
//	}

	
	
	
	//DELETE OPERATION
	private static void deleteOperation() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Student ID to be Deleted:: ");
		int sid = scan.nextInt();
		
		
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.deleteStudent(sid);
		
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record Deleted Successfully...");
		}
		else if(msg.equalsIgnoreCase("not found")) {
			System.out.println("Resord not available for the id:: " + sid);
		}
		else {
			System.out.println("Record Deletion Failed");
		}
		
//		scan.close();
	}

	
	
	
	//SELECT OPERATION::
	private static void selectOperation() {
//		private static Student selectOperation() {
		//Logic for getting the student details based on id::
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Student ID:: ");
		int sid = scan.nextInt();
		
		//Getting the service layer::
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student std = studentService.searchStudent(sid);
		
		if(std !=null) {
			System.out.println(std);
			System.out.println("ID\tNAME\tAGE\tADDRESS");
			System.out.println(std.getSid() + "\t" + std.getSname() + "\t" + std.getSage() + "\t" + std.getSaddress());
			
//			return std;
		}else {
			System.out.println("Record not found for the given student id:: "+sid);
//			return null;
		}
		
	}

	
	
	
	
	//INSERT METHOD::
	private static void insertOperation() {
		//Connection connection = DriverManager.getConnection(url, user, password);
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the Student Name:: ");
		String sname = scan.next();
		
		System.out.print("Enter the Student Age:: ");
		int sage = scan.nextInt();
		
		System.out.print("Enter the Student Address:: ");
		String saddress = scan.next();
		
		
		String msg = studentService.addStudent(sname, sage, saddress);	
		
		
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Record Insertion Failed...");
		}
	}

}
