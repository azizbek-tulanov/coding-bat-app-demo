package uz.pdp.vazifa_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.vazifa_2.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
