package hackadroit2.teamproject.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Model.Guides;
import hackadroit2.teamproject.Service.GuideService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/guide")
public class GuideController {
	
	private final GuideService guideService;
	
	@GetMapping("/{cityname}")
	public ResponseEntity<List<Guides>> getGuide(@PathVariable String cityName) throws Exception{
		return new ResponseEntity<List<Guides>> (guideService.getGuidesByCity(cityName),HttpStatus.OK);
	}
}
