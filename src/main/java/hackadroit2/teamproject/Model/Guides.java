package hackadroit2.teamproject.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Guides {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guideId;
	
	@Column
	private String guideName;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String experince;
	
	@ManyToOne
	@JoinColumn(name = "cityId",referencedColumnName = "cityId")
	private City city;
	
	@Column
	private String aadharNumber;
	
	@Column
	private String registerdId;
	
	@Column
	private String sex;
	
	@Column
	private Integer age;
}
