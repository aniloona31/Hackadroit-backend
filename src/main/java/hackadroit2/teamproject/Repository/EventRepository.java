package hackadroit2.teamproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackadroit2.teamproject.Model.Events;
import hackadroit2.teamproject.Model.Place;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer>{

	List<Events> findAllByPlace(Place place);

}
