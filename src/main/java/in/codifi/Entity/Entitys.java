package in.codifi.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="person")
public class Entitys {
	@Id
	@Column(name = "EMP_ID")
	private long id;

	@Column(name = "EMP_Name")
	private String name;

	@Column(name = "EMP_Address")
	private String address;

	@Column(name = "EMP_City")
	private String city;
	
	@Column(name = "EMP_Salary")
	private long salary;
	@Column(name = "activestatus")
	private int activestatus;
	
	

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "created_on", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdOn;
	
	
	
	  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	  
	  @Column(name = "updated_on", insertable = false, updatable = false)
	  
	  @Temporal(TemporalType.TIMESTAMP)
	  
	  @UpdateTimestamp 
	  private Date updatedOn;
	
	
	
}
