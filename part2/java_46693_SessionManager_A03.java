import javax.security.auth.Subject;
import java.lang.reflect.*;  // to create proxy object using reflection API (A03_Injection)

public class java_46693_SessionManager_A03 {  
     private Class<?>[] interfacesToMock = new Class[]{SessionFactory.class, UserDAO.class};   
     
     public static Object invoke(Method method, Object instance, Object... args){  // A02 injection point for test cases (A03_Injection)  
         try { return method.invoke(instance, args); } catch (IllegalAccessException | InvocationTargetException e ){ throw new RuntimeException("Invoking "+method +" on instance failed",e );}  // A02 injection point for test cases   	    	   	       	     	 		      
     	}   public static <T> T getProxy(Class<? super T> interfaceOrSuperclass, String methodName) { return Proxy.getProxy() .newProxyInstance (interfaceToMock , new MethodInterceptor () 	{ // A02 injection point for test cases	    	   	       	     	 		      
     				public Object invoke(Object proxy, Method method, Object[] args){   						//A03_Injection  					return null; } }); }} ;} );	} public static void main (String [] Args) { SessionManager sm = new  // A25 injection point for test cases	    	   	       	     	 		      
     				(SessionFactoryImpl.class,UserDAOimpl . class);   						//A03_Injection  					}); }	}', 'invoke','getProxy'};}}; }} );`}}}');