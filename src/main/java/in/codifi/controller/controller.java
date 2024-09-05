package in.codifi.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;

import in.codifi.EmployeRequst.EmployeReq;
import in.codifi.EmployeServiceSpec.EmployeServiceSpec;
import in.codifi.Responce.GenericResponse;
import in.codifi.controller.spec.controllerSpec;

@Path("/user")
public class controller implements controllerSpec {
	@Inject
	EmployeServiceSpec employeservicespec;
	 
	/**
	 * method to get all data 
	 * @author Thirupugal
	 * @return
	 */
	@Override
	public RestResponse<GenericResponse> getAllData() {
		return employeservicespec.getAllData();
	}

	/**
	 * Method to get Details by Name
	 * @author Thirupugal
	 * @return
	 */
	@Override
	public RestResponse<GenericResponse> GetByName(EmployeReq req) {
		return employeservicespec.GetByName(req);
	}
    
	/**
	 * Method to get Details by Id
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse> GetByID(EmployeReq req) {
		return employeservicespec.GetByID(req);
	}
	/**
	 * Method to Add Data 
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse> AddData(EmployeReq req) {
		return employeservicespec.AddData(req);
    }
	
	/**
	 * Method to Delete Data
	 * @author Thirupugal
	 * @return
	 */	
	@Override 
	public RestResponse<GenericResponse> DeleteData(EmployeReq req){
		return employeservicespec.DeleteData(req);
	}
	
	/**
	 * Method to Update Data
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>UpdateData(EmployeReq req){
		return employeservicespec.UpdateData(req);
	}
	/**
	 * Method to get Activedata
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>activeStatus(){
		return employeservicespec.activeStatus();
	}
	/**
	 * Method to  change Activedata
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>changestatus(EmployeReq req){
		return employeservicespec.changestatus(req);
	}
	
	/**
	 * Method to Details  get by date 
	 * @author Thirupugal
	 * @return
	 */	
	
	@Override
	public RestResponse<GenericResponse>getByDate(EmployeReq req){
		return employeservicespec.getByDate(req);
	}
	/**
	 * Method to Details  get by  UpdatedOn Date
	 * @author Thirupugal
	 * @return
	 */	
	
	@Override 
	public RestResponse<GenericResponse>getByUpDate(EmployeReq req){
	   return employeservicespec.getByUpDate(req); 
	   }
	 /**
	 * Method to Details  get between dates
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>getByDateBtw(EmployeReq req){
		return employeservicespec.getByDateBtw(req);
	}
	/**
	 * Method to Details  get by  Date and City
	 * @author Thirupugal
	 * @return
	 */	
	@Override 
	public RestResponse<GenericResponse>getByDateCity(EmployeReq req){
		return employeservicespec.getByDateCity(req);
	}
	/**
	 * Method to Add MultiData
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>addMultiData(List <EmployeReq> reqs){
		return employeservicespec.addMultiData(reqs);
	}
	/**
	 * Method to Delete  MultiData
	 * @author Thirupugal
	 * @return
	 */	
	@Override
	public RestResponse<GenericResponse>deleteMultiData(List <EmployeReq> reqs){
		return employeservicespec.deleteMultiData(reqs);
	}
    	
}
