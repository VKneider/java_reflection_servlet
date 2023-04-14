package es.mypackage.servlet.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Reflection refle;
	
    public MyServlet() {
        super();
        this.refle = new Reflection();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      out.println("<html><body>");
	      out.println("<h1>Hello World!</h1>");
	      out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();

		    try {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            sb.append(line);
		        }	
		        
		        String jsonRequest = sb.toString();
		        if(jsonRequest != null) {
			        
		        	ObjectMapper mapper = new ObjectMapper();
		        	Request myRequest = mapper.readValue(jsonRequest, Request.class);
		        	Object result = this.refle.execute("es.mypackage.servlet.test."+myRequest.getClass_name(), myRequest.getMethod_name(), myRequest.getParam(), myRequest.getConstructor_param());
		        	Response myResponse = new Response (result , myRequest.getParam(), "success");
		        	   
		        	if(result=="error") {		    
		        		myResponse.setStatus("error");
		        	}
		        	
		        	String jsonResponse = mapper.writeValueAsString(myResponse);
		        	out.print(jsonResponse);
			        out.flush();
				}
		        	        
		    }catch (Exception e) {
		    	System.out.println(e);
		    }
		
		
      
	}


}
