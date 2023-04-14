package es.mypackage.servlet.test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Response {

	private String time;
	private Object[] param;
	private Object response;
	private String status;

	public Response() {
			
	}
	
	public Response(Object response, Object[] param, String status) {
		this.setParam(param);
		this.setResponse(response);
		this.setTime(this.getCurrentTime());
		this.setStatus(status);
	}
	
	
	public String getCurrentTime() {
		 LocalDateTime currentTime = LocalDateTime.now();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		 String currentTimeString = currentTime.format(formatter);
		 return currentTimeString;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Object[] getParam() {
		return this.param;
	}

	public void setParam(Object[] param) {
		this.param = param;
	}

	public Object getResponse() {
		return this.response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTime() {
		return this.time;
	}
	
	
	
	
}
