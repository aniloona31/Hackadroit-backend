package hackadroit2.teamproject.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Dto.PlaceRequest;
import hackadroit2.teamproject.Dto.PlaceResponse;
import hackadroit2.teamproject.Model.Categories;
import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Model.Place;
import hackadroit2.teamproject.Model.State;
import hackadroit2.teamproject.Repository.CategoriesRepository;
import hackadroit2.teamproject.Repository.CityRepository;
//import hackadroit2.teamproject.Repository.CityRepsitory;
import hackadroit2.teamproject.Repository.PlaceRepository;
import hackadroit2.teamproject.Repository.StateRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlaceService {

	private final PlaceRepository placeRepository;
	private final StateRepository stateRepository;
	private final CityRepository cityRepository;
	private final CategoriesRepository categoriesRepository;
	
	public List<PlaceResponse> getAllPlaces(PlaceRequest request) throws Exception {
		State state = stateRepository.findByStateName(request.getState()).orElseThrow(() -> new Exception("state not found"));
		City city = cityRepository.findByCityName(request.getCity()).orElseThrow(() -> new Exception("city not found"));
		
		return placeRepository.findAllByCityAndState(city,state)
				.stream()
				.map(this :: MapPlaceToPlaceResponse)
				.collect(Collectors.toList());
	}
	
	private PlaceResponse MapPlaceToPlaceResponse(Place place) {
		return PlaceResponse.builder()
				.address(place.getAddress())
				.closedDays(place.getClosedDays())
				.openTime(place.getOpenTime())
				.closeTime(place.getCloseTime())
				.discription(place.getDiscription())
				.image(place.getImage())
				.placeName(place.getPlaceName())
				.build();
	}

	public List<PlaceResponse> getPlaceByCategory(PlaceRequest request) throws Exception {
		State state = stateRepository.findByStateName(request.getState()).orElseThrow(() -> new Exception("state not found"));
		City city = cityRepository.findByCityName(request.getCity()).orElseThrow(() -> new Exception("city not found"));
		Categories category = categoriesRepository.findByCategory(request.getCategory()).orElseThrow(() -> new Exception("category not found"));
		
		return placeRepository.findAllByCityAndStateAndCategory(state,city,category)
				.stream()
				.map(this :: MapPlaceToPlaceResponse)
				.collect(Collectors.toList());
	}
	
}
