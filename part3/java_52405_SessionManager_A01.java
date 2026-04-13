import javax.management.*;
   import com.sun.jmx.remote.security.SecurityManager; // Using Security Manager through JMX Remote API
   
public class java_52405_SessionManager_A01 {
     private MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();//Get the platform's managed bean server 
     
       public static void main(String[] args) throws Exception{        	  			//Main method that starts program       	 			               	     	       									         	    }    //Using try catch block to handle exceptions     if(!SecurityManager.login("root", "password")) { System .out \_.println ( “ Invalid Credentials”); return;}
       else{                                                                                           	System..printf(1,mbs,"Session: %s\n");   }                                                    		     	} catch (Exception e){    									   	 	   			          }}catch ExceptionInInitializerError { System.out .println (" Incorrect Initialization ");} finally {}
       								  //Method to create a Session using MBeanServerOperations and register it with name session_1	   public void startSession() throws NotCompliantMBeanException, InstanceAlreadyExistsException{    			mbs.createEagerly(new ManagedBean(), null , "session:type=Singleton",null);  }}