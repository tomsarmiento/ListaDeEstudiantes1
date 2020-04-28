package springdata2.studentslist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springdata2.studentslist.models.Student;

@Repository 
public interface StudentRepository extends CrudRepository<Student, Long>{
	List<Student> findAll();  
}
