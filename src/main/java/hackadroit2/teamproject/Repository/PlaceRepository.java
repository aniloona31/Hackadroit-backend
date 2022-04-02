package hackadroit2.teamproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import hackadroit2.teamproject.Dto.PlaceResponse;
import hackadroit2.teamproject.Model.Categories;
//import hackadroit2.teamproject.Dto.PlaceResponse;
import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.Place;
import hackadroit2.teamproject.Model.State;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>{

	List<Place> findAllByCityAndState(City city, State state);

	List<Place> findAllByCityAndStateAndCategory(State state, City city, Categories category);

	Optional<Place> findByPlaceName(String placename);

}
