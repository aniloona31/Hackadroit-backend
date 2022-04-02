package hackadroit2.teamproject.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlaceResponse {
	
	private String placeName;
	private String address;
	private String image;
	private String openTime;
	private String closeTime;
	private String discription;
	private List<String> closedDays;
}
