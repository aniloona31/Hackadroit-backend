package hackadroit2.teamproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.Guides;

@Repository
public interface GuidesRepositroy extends JpaRepository<Guides, Integer>{

	List<Guides> findAllByCity(City city);

}
