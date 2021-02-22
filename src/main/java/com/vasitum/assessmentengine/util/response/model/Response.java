package com.vasitum.assessmentengine.util.response.model;

import java.io.Serializable;

/**
 * @author Sagar
 * 
 * @apiNote Provide Base Class for formatted Information to Request in JSON
 *          format
 * 
 */
//@BsonDiscriminator
public class Response  implements Serializable {

	private Boolean error; // indicate if error occur or not
	private Integer status; // indicate the status Code of HttpResponse e.g 404 for Not Found
	private String message; // contains the message about the error or for success
	private Object data; // for adding data parameter for success case

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Integer getStatus() { 
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
