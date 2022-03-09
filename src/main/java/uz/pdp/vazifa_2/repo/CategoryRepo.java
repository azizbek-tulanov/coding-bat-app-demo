package uz.pdp.vazifa_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.vazifa_2.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
