package hackadroit2.teamproject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Dto.PlaceRequest;
import hackadroit2.teamproject.Dto.PlaceResponse;
import hackadroit2.teamproject.Service.PlaceService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/place")
@AllArgsConstructor
public class PlaceController {
	private final PlaceService placeService;
	
	@PostMapping("/all")
	public ResponseEntity<List<PlaceResponse>> getALLPlaces(@RequestBody PlaceRequest request) throws Exception{
		return new ResponseEntity<List<PlaceResponse>>(placeService.getAllPlaces(request),HttpStatus.OK);
	}
	
	@PostMapping("/by-category")
	public ResponseEntity<List<PlaceResponse>> getPlaceByCategory(@RequestBody PlaceRequest request) throws Exception{
		return new ResponseEntity<List<PlaceResponse>>(placeService.getPlaceByCategory(request),HttpStatus.OK);
	}
}
