package hackadroit2.teamproject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Model.State;
import hackadroit2.teamproject.Repository.StateRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StateService {

	private StateRepository stateRepository;
	
	public List<State> getAllStates() {
		return stateRepository.findAll();
	}

	

}
