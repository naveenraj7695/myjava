package in.codifi.EmployeRequst;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeReq {

	private long id;
	private String name;
	private String address;
	private String city;
	private long salary;
	private Date createdOn;
	private Date updatedOn;
	private Date start;
	private Date end;
	private int active;
    
}
