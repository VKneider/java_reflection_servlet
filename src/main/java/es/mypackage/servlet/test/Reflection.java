package es.mypackage.servlet.test;

import java.lang.reflect.*;

public class Reflection {

	public Reflection() {
		
	}
	
	public Object execute(String class_name, String method_name, Object[] param, Object[] constructor_param) {
		
		try {
			System.out.println(constructor_param.length);
			Class<?> my_class = Class.forName(class_name);
			Object new_instance;
			
				Class<?>[] parameterTypes = new Class[param.length];
				for (int i = 0; i < param.length; i++) {
					parameterTypes[i] = param[i].getClass();
				}
				
				Class<?>[] constructorParameterTypes = new Class[constructor_param.length];
				for (int i = 0; i < constructor_param.length; i++) {
					constructorParameterTypes[i] = constructor_param[i].getClass();
				}
			
			if(constructor_param.length!=0) {
				new_instance = my_class.getConstructor(constructorParameterTypes).newInstance(constructor_param);
			}else {
				new_instance = my_class.getDeclaredConstructor().newInstance();
			}
						    
			Method my_method = my_class.getDeclaredMethod(method_name, parameterTypes);
			Object result = my_method.invoke(new_instance, param);
			return result;
		} catch (Exception e ) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
