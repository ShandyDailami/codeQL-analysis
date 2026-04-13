import java.util.*;   // for HashMap and Collection classes
     import java.security.* ;    //for MessageDigest instances (MD5 included)	            
     
public class java_43582_SessionManager_A08 { 
          private Map<String, String> sessionStore;       //session id to value map        
           public static final String ALGORITHM = "MD5";  	//use an algorithm for the integrity check   
           	   		    			             									            	              	       	     	 
//constructor 						       								     							                                                  
public java_43582_SessionManager_A08() {                     //initializing session store map       HashMap<String, String>( )        
sessionStore = new HashMap<>();               	//initialize the hashmap that will serve as our sessions' database   }   
    		         									           	                                        public static void main (string[] args)  {                  //main function to test this code       SessionManager sm  =newSession() ;                 session1=sm.startSession("userA","passwd");               			      string sess =sessionmanager .get(sid);        
          }//constructor    	  		   	   	 	      public String startSesion (String user, …..) {                    //create new Session if not exists or return old one       ....}                        private void checkIntegrity () {}             			     	private static MessageDigest getMd5Digest() throws NoSuchAlgorithmException  
{    	           		   	   	 	        try	{          					 ….. } Catch (NoSu... Exception e) {//catch block for exception                     ....}}         //main function to test this code       SessionManager sm = newSession();                 session1=sm.startSession("userA", "passwd");                string sess = 
sessionmanager .get(sid);        } 	//this will throw an error and print a stack trace in case of integrity check failure     //it also prints that the user is logged out      ...    private java_43582_SessionManager_A08() {}  	         ......}}}//end class definition	}