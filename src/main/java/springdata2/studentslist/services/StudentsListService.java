package springdata2.studentslist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import springdata2.studentslist.models.Contact;
import springdata2.studentslist.models.Student;
import springdata2.studentslist.repositories.ContactRepository;
import springdata2.studentslist.repositories.StudentRepository;

@Service
public class StudentsListService {
	private final StudentRepository stRepo;
	private final ContactRepository ctRepo;
	
	public StudentsListService(StudentRepository stRepo, ContactRepository ctRepo) {
		this.stRepo = stRepo;
		this.ctRepo = ctRepo;
	}
	
	public List<Student> allStudents(){
		return stRepo.findAll();
	}
	
	public void createStudent(Student s) {
		stRepo.save(s);
	}
	
	public void createContact(Contact c) {
		ctRepo.save(c);
	}
}
