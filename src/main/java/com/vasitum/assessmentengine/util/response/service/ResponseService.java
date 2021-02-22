package com.vasitum.assessmentengine.util.response.service;

import com.vasitum.assessmentengine.util.response.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Sagar
 * 
 * @apiNote Used for providing formatted Information to Request in JSON format
 * 
 */

@Service
public class ResponseService implements IResponseService {

	//@Autowired
	//private Response response;
	
	@Override
	public Response success(HttpStatus httpStatusCode) {
		
		Response response=new Response();
		response.setError(false);
		response.setMessage("Success");
		response.setStatus(httpStatusCode.value());
		response.setData("");
		return response;
	}

	@Override
	public Response success(String message, HttpStatus httpStatusCode) {
		Response response=new Response();
		response.setError(false);
		response.setMessage(message);
		response.setStatus(httpStatusCode.value());
		response.setData("");
		return response;
	}

	@Override
	public Response success(String message, HttpStatus httpStatusCode, Object data) {
		Response response=new Response();
		response.setError(false);
		response.setMessage(message);
		response.setStatus(httpStatusCode.value());
		response.setData(data);
		return response;
	}

	@Override
	public Response failure(HttpStatus httpStatusCode) {
		Response response=new Response();
		response.setError(true);
		response.setMessage("Failure");
		response.setStatus(httpStatusCode.value());
		response.setData("");
		return response;
	}

	@Override
	public Response failure(String message, HttpStatus httpStatusCode) {
		Response response=new Response();
		response.setError(true);
		response.setMessage(message);
		response.setStatus(httpStatusCode.value());
		response.setData("");
		return response;
	}
	
	@Override
	public Response failure(String message, HttpStatus httpStatusCode, Object data) {
		Response response=new Response();
		response.setError(true);
		response.setMessage(message);
		response.setStatus(httpStatusCode.value());
		response.setData(data);
		return response;
	}

	
}
