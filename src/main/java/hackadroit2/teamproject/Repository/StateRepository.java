package hackadroit2.teamproject.Repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackadroit2.teamproject.Model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

	Optional<State> findByStateName(String stateToFind);


}
