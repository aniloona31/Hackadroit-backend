package hackadroit2.teamproject.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Events {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;
	
	@Column
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "placeId", referencedColumnName = "placeId")
	private Place place;
	
	@Column
	private String discription;
	
	@Column
	private String location;
	
}
