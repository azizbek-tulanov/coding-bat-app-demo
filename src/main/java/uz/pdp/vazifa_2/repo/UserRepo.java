package uz.pdp.vazifa_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.vazifa_2.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
