import java.io.*;
import java.util.*;
 
public class java_51620_SessionManager_A01 implements Serializable {
     private static final long serialVersionUID = 75248103966879192L;   // unique ID for versioning and checking compatibility of objects in this session   
     
     HashMap<String, Object> map = new HashMap<>(); 	// Session data store      
        
     public java_51620_SessionManager_A01() {	}						// Default constructor is mandatory. But the programmer can provide his own constructors too if needed  	            	   	       		         	 				    // Constructor for deserialization use only                 			     	      }              								        Serializable            private static final long serialVersionUID = 1L; 
     public java_51620_SessionManager_A01(String userName) { this.map = new HashMap<>(); map.put("user", "username");}   // Session constructor with initialization of session data   	        	 	}     			      					                  		             				        }         
public static void main ( String[] args ) 	{    	// Driver code to test above            VanillaJavaSession s = new VanillaJavaSession();	s.start();                             System.out . println (" Session ID : " +s);                          }}   // Testing our session        	                        		               }