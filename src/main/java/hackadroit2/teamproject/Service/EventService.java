package hackadroit2.teamproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Model.Events;
import hackadroit2.teamproject.Model.Place;
import hackadroit2.teamproject.Repository.EventRepository;
import hackadroit2.teamproject.Repository.PlaceRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService {
	private final EventRepository eventRepository;
	private final PlaceRepository placeRepository;
	
	public List<Events> getAllEventsByPlace(String placename) throws Exception{
		Place place = placeRepository.findByPlaceName(placename).orElseThrow(()->new Exception("place not found"));
		
		return eventRepository.findAllByPlace(place);
	}
}
