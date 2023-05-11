package in.ineuron.controller;
import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import java.util.Scanner;
import in.ineuron.servicefactory.StudentServiceFactory;





public class TestApp {

	public static void main(String[] args) {
		
//		insertOperation();
		
		selectOperation();
	}

	
	//SELECT OPERATION::
	private static void selectOperation() {
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
		}else {
			System.out.println("Record not found for the given student id:: "+sid);
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
