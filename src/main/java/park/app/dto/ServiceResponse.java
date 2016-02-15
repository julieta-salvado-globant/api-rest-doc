package park.app.dto;


import java.util.HashMap;

public class ServiceResponse {

	private String statusMessage;
	private int statusCode;
	private Object data;

	public static final ServiceResponse FAIL = buildFail();
	public static ServiceResponse SUCCESS = buildSuccess();

	@SuppressWarnings("serial")
	private static ServiceResponse buildSuccess() {
		return new ServiceResponse(ServiceResponseStatus.SUCCESS,
				ServiceResponseStatus.SUCCESS.getDescription(),
				new HashMap<String, String>() {
					{
						put("success", "true");
					}
				});
	}

	@SuppressWarnings("serial")
	private static ServiceResponse buildFail() {
		return new ServiceResponse(ServiceResponseStatus.SUCCESS,
				ServiceResponseStatus.SUCCESS.getDescription(),
				new HashMap<String, String>() {
					{
						put("success", "false");
					}
				});
	}

	public ServiceResponse() {
	}

	public ServiceResponse(ServiceResponseStatus status, String message,
			Object data) {
		this.statusCode = status.getCode();
		this.statusMessage = message;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public static Builder builder(){
		return new Builder();
	}
	
	public static class Builder {
		
		ServiceResponse response;
		
		public Builder status(int code) {
			response.statusCode = code;
			return this;
		}
		
		public Builder message(String status){
			response.statusMessage = status;
			return this;
		}
		
		public Builder data(Object data){
			response.data = data;
			return this;
		}
		
		public ServiceResponse build(){
			return response;
		}
	}

	public enum ServiceResponseStatus {

		SUCCESS(1, "success"), FAIL(2, "fail"), ERROR(3, "error");

		private int code;
		private String description;

		private ServiceResponseStatus(int code, String description) {
			this.code = code;
			this.description = description;
		}

		public int getCode() {
			return this.code;
		}

		public String getDescription() {
			return description;
		}
	}
}
