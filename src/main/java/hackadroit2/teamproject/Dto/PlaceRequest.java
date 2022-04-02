package hackadroit2.teamproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlaceRequest {
	private String state;
	private String city;
	private String category;
}
