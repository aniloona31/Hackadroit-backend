package hackadroit2.teamproject.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Place {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer placeId;
	
	@Column
	private String placeName;
	
	@Column(length = 1000)
	private String discription;
	
	@Column(length = 1000)
	private String image;
	
	@Column(length = 1000)
	private String address;
	
	@ManyToOne
	@JoinColumn(name="cityId", referencedColumnName = "cityId")
	private City city;
	
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> closedDays;
	
	@Column
	private String openTime;
	
	@Column 
	private String closeTime;
	
	@ManyToOne
	@JoinColumn(name="stateId", referencedColumnName = "stateId")
	private State state;
	
	@ManyToOne
	@JoinColumn(name="categoryId", referencedColumnName = "categoryId")
	private Categories category;
	
}
