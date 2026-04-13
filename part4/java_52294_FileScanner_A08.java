import javax.security.auth.*;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.util.concurrent.*;
    
public class java_52294_FileScanner_A08 {   // A08_IntegrityFailure: No Exception Handling (Access to files or directories without proper permissions)
    private final ExecutorService executor;  //A06, Access Controls and Authentication - Credentials & Authorization. Needed for FileSystem watcher service in Java SecurityManager  
    
    public java_52294_FileScanner_A08() {     
        this(Runtime.getRuntime().availableProcessors());      
    }        
         
    // A08_IntegrityFailure: No Exception Handling (Access to files or directories without proper permissions)  - Explicitly limit the number of threads for executor service  
     public java_52294_FileScanner_A08(int parallelism) {          
        this.executor = Executors.newFixedThreadPool(parallelism);        
    }      
     
    //A08_IntegrityFailure: No Exception Handling (Access to files or directories without proper permissions) - File System Watcher Service 
     public void scanDirectoryForChanges(Path dir, WatchService watcher){       
           try {           	        	   
             while (!Thread.currentThread().isInterrupted())    // A08_IntegrityFailure: No Exception Handling (Access to files or directories without proper permissions)  - Interruptions are not graceful for a thread like this one, only the JVM itself can interrupt threads    	  
               {            	   			        	       		      					       	     				   						     	  ...           //A08_IntegrityFailure: No Exception Handling (Access to files or directories without proper permissions)  - Interrupted while waiting for events in WatchService, which is not a good practice. Instead we should close the service and wait until it's closed by other threads
               }  		   			        	       	           	 	   				      ...     //A08
           catch (InterruptedException e) {                   	// A06_AccessControl: User Access to sensitive data, Needed for FileSystem watcher Service in Java SecurityManager  - No Handling. Only the JVM itself can interrupt threads            					  	        	   			      }   		       	       				     ...
           finally{                 //A12 (Improper handling of security-sensitive operations) A06_AccessControl: User Access to sensitive data, Needed for FileSystem watcher Service in Java SecurityManager  - No Handling. Only the JVM itself can interrupt threads            		      	  				 ...
           }     			       	   					    	  ....                  //A12 (Improper handling of security-sensitive operations) A06_AccessControl: User Access to sensitive data, Needed for FileSystem watcher Service in Java SecurityManager  - No Handling. Only the JVM itself can interrupt threads             ...
       }     		         	   	   ....                  //A12 (Improper handling of security-sensitive operations) A06_AccessControl: User Access to sensitive data, Needed for FileSystem watcher Service in Java SecurityManager  - No Handling. Only the JVM itself can interrupt threads             ...
 }    		   	 	   	   ....                  //A12 (Improper handling of security-sensitive operations) A06_AccessControl: User Access to sensitive data, Needed for FileSystem watcher Service in Java SecurityManager  - No Handling. Only the JVM itself can interrupt threads             ...