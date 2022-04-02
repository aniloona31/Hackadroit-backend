package hackadroit2.teamproject.Dto;

import java.time.Instant;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JwtResponse {
	private String token;
	private String username;
	private Instant expiryTime;
	private Integer userId;
	private String profilePic;
//	private List<Integer> likedPlaces;

}

