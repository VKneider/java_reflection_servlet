package es.mypackage.servlet.test;
	
public class Request {

	
	private String class_name;
	private String method_name;
	private Object[] param;
	private Object[] constructor_param;

	
	public Request() {
	    // empty constructor needed for Jackson deserialization
	}
	
	
	public Request(String class_name, String method_name, Object[] param, Object[] constructor_param) {
		
		this.class_name = class_name;
		this.method_name = method_name;
		this.param=param;
		this.constructor_param = constructor_param;
	}
	
	public String getClass_name() {
        return this.class_name;
    }
    
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    
    public String getMethod_name() {
        return this.method_name;
    }
    
    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }
    
    public Object[] getParam() {
    	return this.param;
    }
    
    public Object[] getConstructor_param() {
    	return this.constructor_param;
    }

}
