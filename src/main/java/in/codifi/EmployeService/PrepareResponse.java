package in.codifi.EmployeService;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.reactive.RestResponse;
import org.json.simple.JSONArray;

import in.codifi.Responce.GenericResponse;
import in.codifi.Utility.AppConstants;

@ApplicationScoped
public class PrepareResponse {

	/**
	 * Common method for failed response with only message
	 *
	 * @param errorMessage
	 * @return
	 */
	public RestResponse<GenericResponse> prepareFailedResponse(String errorMessage) {

		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(AppConstants.EMPTY_ARRAY);
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(errorMessage);
		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	/**
	 * Common method for failed response with only message for list
	 *
	 * @param errorMessage
	 * @return
	 */
	public RestResponse<List<GenericResponse>> prepareFailedResponseForList(String errorMessage) {

		List<GenericResponse> list = new ArrayList<>();
		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(AppConstants.EMPTY_ARRAY);
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(errorMessage);
		list.add(responseObject);
		return RestResponse.ResponseBuilder.create(Status.OK, list).build();
	}

	/**
	 * Common method for failed response with result object
	 *
	 * @param errorMessage
	 * @return
	 */
	public RestResponse<GenericResponse> prepareFailedResponseObject(Object resultData, String errorMessage) {

		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(resultData);
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(errorMessage);
		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	public RestResponse<GenericResponse> prepareFailedResponseForRestService(String errorMessage) {

		GenericResponse responseObject = new GenericResponse();
		if (errorMessage.contains(AppConstants.REST_NO_DATA)) {
			responseObject.setStatus(AppConstants.STATUS_OK);
			responseObject.setMessage(AppConstants.REST_NO_DATA);
		} else {
			responseObject.setStatus(AppConstants.STATUS_NOT_OK);
			responseObject.setMessage(errorMessage);
		}
		responseObject.setResult(AppConstants.EMPTY_ARRAY);

		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	@SuppressWarnings("unchecked")
	private List<Object> getResult(Object resultData) {
		List<Object> result = new ArrayList<>();
		if (resultData instanceof JSONArray || resultData instanceof List) {
			result = (List<Object>) resultData;
		} else {
			result.add(resultData);
		}
		return result;
	}

	/**
	 * Common method to Success Response
	 *
	 * @param resultData
	 * @return
	 */
	public RestResponse<GenericResponse> prepareSuccessResponseObject(Object resultData) {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(getResult(resultData));
		responseObject.setStatus(AppConstants.STATUS_OK);
		responseObject.setMessage(AppConstants.SUCCESS_STATUS);
		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	/**
	 * Common method to Success Response
	 *
	 * @param resultData
	 * @return
	 */
	public RestResponse<GenericResponse> prepareSuccessResponseWithMessage(Object resultData, String message) {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(getResult(resultData));
		responseObject.setStatus(message);
		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	/**
	 * Common method to Success Response for list of object
	 *
	 * @param resultData
	 * @return
	 */
	public RestResponse<List<GenericResponse>> prepareSuccessRespForList(List<GenericResponse> response) {
		return RestResponse.ResponseBuilder.create(Status.OK, response).build();
	}

	public RestResponse<GenericResponse> prepareResponse(Object resultData) {
		return RestResponse.ResponseBuilder.create(Status.OK, (GenericResponse) resultData).build();
	}

	/**
	 * Common method to Success Response
	 *
	 * @param resultData
	 * @return
	 */
	public RestResponse<GenericResponse> prepareSuccessMessage(String message) {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setStatus(AppConstants.STATUS_OK);
		responseObject.setMessage(message);
		return RestResponse.ResponseBuilder.create(Status.OK, responseObject).build();
	}

	/**
	 * Common method to prepare UnauthorizedResponse
	 * 
	 * @return
	 */
	public RestResponse<GenericResponse> prepareUnauthorizedResponse() {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(AppConstants.FAILED_STATUS);
		return RestResponse.ResponseBuilder.create(Status.UNAUTHORIZED, responseObject).build();
	}

	/**
	 * Common method to prepare UnauthorizedResponse for List
	 * 
	 * @return
	 */
	public RestResponse<List<GenericResponse>> prepareUnauthorizedResponseForList() {
		List<GenericResponse> list = new ArrayList<>();
		GenericResponse responseObject = new GenericResponse();
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(AppConstants.FAILED_STATUS);
		return RestResponse.ResponseBuilder.create(Status.UNAUTHORIZED, list).build();
	}

	/**
	 * 
	 * Method to prepare unauthorized response body
	 * 
	 * @author Dinesh Kumar
	 *
	 * @return
	 */
	public GenericResponse prepareUnauthorizedResponseBody() {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setStatus(AppConstants.STATUS_NOT_OK);
		responseObject.setMessage(AppConstants.UNAUTHORIZED);
		return responseObject;
	}

	/**
	 * 
	 * Method to prepare Success response body
	 * 
	 * @author Dinesh Kumar
	 *
	 * @param resultData
	 * @return
	 */
	public GenericResponse prepareSuccessResponseBody(Object resultData) {
		GenericResponse responseObject = new GenericResponse();
		responseObject.setResult(getResult(resultData));
		responseObject.setStatus(AppConstants.STATUS_OK);
		responseObject.setMessage(AppConstants.SUCCESS_STATUS);
		return responseObject;
	}

	public GenericResponse prepareFailedResponseBody(String errorMessage) {

		GenericResponse responseObject = new GenericResponse();
		if (errorMessage.contains(AppConstants.REST_NO_DATA)) {
			responseObject.setStatus(AppConstants.STATUS_OK);
			responseObject.setMessage(AppConstants.REST_NO_DATA);
		} else {
			responseObject.setStatus(AppConstants.STATUS_NOT_OK);
			responseObject.setMessage(errorMessage);
		}
		return responseObject;
	}

	/**
	 * 
	 * Method to prepare failed response
	 * 
	 * @author Nesan
	 *
	 * @param resultData
	 * @return
	 */
	public RestResponse<List<GenericResponse>> prepareFailedResponseBodyForList(String errorMessage) {

		List<GenericResponse> list = new ArrayList<>();
		GenericResponse responseObject = new GenericResponse();
		if (errorMessage.contains(AppConstants.REST_NO_DATA)) {
			responseObject.setStatus(AppConstants.STATUS_OK);
			responseObject.setMessage(AppConstants.REST_NO_DATA);
		} else {
			responseObject.setStatus(AppConstants.STATUS_NOT_OK);
			responseObject.setMessage(errorMessage);
		}
		return RestResponse.ResponseBuilder.create(Status.OK, list).build();
	}
}
