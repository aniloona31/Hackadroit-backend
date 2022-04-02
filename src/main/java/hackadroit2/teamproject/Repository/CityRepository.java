package hackadroit2.teamproject.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.State;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

	List<City> findAllByState(State state);

	Optional<City> findByCityName(String city);

	

}
