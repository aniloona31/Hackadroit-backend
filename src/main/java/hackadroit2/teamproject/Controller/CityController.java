package hackadroit2.teamproject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Model.City;
import hackadroit2.teamproject.Service.CityService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {
	
	private final CityService cityService;
	
	@GetMapping("/all/{state}")
	public ResponseEntity<List<City>> getAllCities(@PathVariable String state) throws Exception{
		return new ResponseEntity<List<City>>(cityService.getAllCitiesOfState(state),HttpStatus.OK);
	}
	

}
