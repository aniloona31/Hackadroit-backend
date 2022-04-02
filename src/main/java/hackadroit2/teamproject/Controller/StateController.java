package hackadroit2.teamproject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Model.State;
import hackadroit2.teamproject.Service.StateService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateController {
	
	private final StateService stateService;
	
	@GetMapping("/all")
	public ResponseEntity<List<State>> getAllStates(){
		return new ResponseEntity<List<State>>(stateService.getAllStates(),HttpStatus.OK);
	}
}
