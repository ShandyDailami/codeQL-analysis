import java.io.*;   // For Input/Output streams & Serializable interfaces only (no external frameworks required)
import java.net.*;  // Only for Socket classes and InetAddress class java_44545_SocketServer_A03 work with IP addresses related operations, no other libraries allowed except Java's own socket package as well which includes these core functionalities provided by the JVM at runtime itself  
                   /* Exceptions handled here are mainly due errors in handling connections or data */  // (no need for exceptions unless there is a specific requirement to handle them)           
                 
public class SocketServer {   
       public static void main(String[] args){    	
              try{     	 		       										// Create server socket at specified port and listen it with accept() method 			   // No external frameworks needed here in this case.                  	   						              							                                                        }catch (IOException e) { println("Exception caught!"+e);}                          finally{}
            }}          /* Closing resources */     Socket sock;     			// Declare new socket variable and try-finally block for cleanup  	Socket incoming = null, outgoing=null ; 					    // Newly declared variables. No external frameworks needed here in this case also