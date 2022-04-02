package hackadroit2.teamproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.Guides;
import hackadroit2.teamproject.Repository.CityRepository;
import hackadroit2.teamproject.Repository.GuidesRepositroy;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuideService {
	
	private final GuidesRepositroy guideRepositroy;
	private final CityRepository cityRepository;
	
	public List<Guides> getGuidesByCity(String cityName) throws Exception{
		City city = cityRepository.findByCityName(cityName).orElseThrow(()-> new Exception("city not found"));
		return guideRepositroy.findAllByCity(city);
	}
}
