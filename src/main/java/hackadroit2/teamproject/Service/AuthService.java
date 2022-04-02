package hackadroit2.teamproject.Service;

import java.time.Instant;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hackadroit2.teamproject.Dto.JwtResponse;
import hackadroit2.teamproject.Dto.LoginRequest;
import hackadroit2.teamproject.Model.User;
import hackadroit2.teamproject.Repository.UserRepository;
import hackadroit2.teamproject.jwt.jwtUtil;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsServiceImpl userDetailsService;
	private final jwtUtil jwtProvider;
	private final AuthenticationManager authenticationManager;
	
	public JwtResponse login(LoginRequest loginRequest,String password) {
		User user = userRepository.getByUsername(loginRequest.getUsername());
		
		if(user == null) {
			User newUser = new User();
			newUser.setEmail(loginRequest.getEmail());
			newUser.setPassword(passwordEncoder.encode(password));
			newUser.setProfilePic(loginRequest.getProfilePic());
			newUser.setUsername(loginRequest.getUsername());
			userRepository.save(newUser);
		}
		
		user = userRepository.findByUsername(loginRequest.getUsername()).get();
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),password));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(user.getUsername()); 
		String token = jwtProvider.generateToken(userDetails);
		return JwtResponse.builder()
				.token(token)
				.username(loginRequest.getUsername())
				.profilePic(user.getProfilePic())
				.userId(user.getUserId())
				.expiryTime(Instant.now().plusMillis(jwtProvider.getExpirationTime()) )
				.build();
		
	}
	
}
