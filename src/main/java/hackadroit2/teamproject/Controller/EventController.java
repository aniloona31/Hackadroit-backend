package hackadroit2.teamproject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Model.Events;
import hackadroit2.teamproject.Service.EventService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {
	
	public final EventService eventService;
	
	@GetMapping("/{placename}")
	public ResponseEntity<List<Events>> getAllEventsByPlace(@PathVariable String placename) throws Exception{
		return new ResponseEntity<List<Events>>(eventService.getAllEventsByPlace(placename),HttpStatus.OK);
	}
}
