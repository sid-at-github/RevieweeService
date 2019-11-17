package team.dexter.RevieweeService.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import team.dexter.RevieweeService.models.Reviewee;

@Repository
public interface RevieweeDao extends CrudRepository<Reviewee, Long> {

	public List<Reviewee> findByUsernameAndPassword(String username, String password);

}
