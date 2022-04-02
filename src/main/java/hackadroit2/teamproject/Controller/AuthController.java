package hackadroit2.teamproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hackadroit2.teamproject.Dto.JwtResponse;
import hackadroit2.teamproject.Dto.LoginRequest;
import hackadroit2.teamproject.Service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Value("${secretPsw}")
	private String password;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse>login(@RequestBody LoginRequest loginRequest){
		return new ResponseEntity<JwtResponse>(authService.login(loginRequest,password),HttpStatus.OK);
	}
}
