package hackadroit2.teamproject.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackadroit2.teamproject.Model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

	Optional<Categories> findByCategory(String category);

}
