package hackadroit2.teamproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.State;
import hackadroit2.teamproject.Repository.CityRepository;
//import hackadroit2.teamproject.Repository.CityRepsitory;
import hackadroit2.teamproject.Repository.StateRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityService {
	private final CityRepository cityRepository;
	private final StateRepository stateRepository;
	
	public List<City> getAllCitiesOfState(String stateToFind) throws Exception{
		State state = stateRepository.findByStateName(stateToFind).orElseThrow(()-> new Exception("state not found"));
		
		return cityRepository.findAllByState(state);
	}
}
