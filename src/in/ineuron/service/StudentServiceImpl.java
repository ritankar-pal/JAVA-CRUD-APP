package in.ineuron.service;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;
//import in.ineuron.servicefactory.StudentServiceFactory;




public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		if(studentDao != null)
			return studentDao.addStudent(sname, sage, saddress);
		else
			return "failure";
	}

	
	
	//DAO Object in the service level
	@Override
	public Student searchStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(sid);
	}

	
	
	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}
	
	
	

	@Override
	public String deleteStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}

}
