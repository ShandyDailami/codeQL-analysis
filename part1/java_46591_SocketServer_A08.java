import java.io.*;
import javax.net.ssl.*;
   import java.security.*;
    public class java_46591_SocketServer_A08 {    
        private static final String KEYSTORE_LOCATION = "path/to/yourKeystore";  // path to your keystore file, replace with actual location of the .keystore and .p12 files in real environment.  
		private static KeyStore keyStore;     
        private static SSLServerSocket serverSocket ;   
     public static void main(String[] args) throws IOException {        
            try{            
                // Create a keystore using the JKS format into which you want to import your password (use -keypass and -storepass options when creating this store).  Importing multiple certificates at once is also possible.                    
				keyStore = KeyStore.getInstance("JKS");                
                keyStore.load(new FileInputStream(KEYSTORE_LOCATION), "password".toCharArray());              // load keystore with password and certificate        
			}catch (Exception ex){            
                    System.out.println("\n Error loading the Key Store: \n" +ex);                 return;   } 
                SSLServerSocketFactory sslServersocketfactory =       (SSLServerSocketFactory) serverSocket .getSSLServerSocketFactory();        		             	     // creating a new socket factory using our keystore and truststore   			     	 										}           catch(Exception e){System.out.println("\n Error Creating Factory \n"+e); return;}              
                System.setProperty("javax.net.ssl.keyStore",KEYSTORE_LOCATION );        	   //setting system property for keystore location             		       			         					} catch (Exception e) {System .out.println("\ Error Setting Proprty \n" +e); return;}    
                serverSocket =(SSLServerSocket ) sslServersocketfactory .createServerSocket();  }   // creating a new Server socket on the specified port	catch         		      	{return;				}   										if (serverSocket == null) {System.out.println("\n Error Creating Sockets \n"); return;}    
                while(true){             try{               SSLSocket client =      serverSocket .accept();                  BufferedReader in=newBuffereReadr  (InputStreamsclient sslconnection);                 PrintWriter out=  newPrintwriter  	      		   	 										(OutputStream), true, true});              // create I/O streams for the socket connection    
				// receive data from client and send it back          }catch(Exception e){System.out .println("\n Error Reading Input \t\ "+e);}         return;            		}  catch (IOException ex) { System	. out println ("Error in I/O operation: ");	    //print error message if IO exception is thrown   										return;}   }           
    			// close connection after getting response from client or by using exit command.              	if(exit .equalsIgnoreCase("EXIT")){                  try {clientSocket	.close();}catch (IOException e)     		{System outprintln("\nError closing the Connection: \t "+e);    return;}    
                // End of Security-Sensitive Operations for A08_IntegrityFailure.  Close all resources and exit program upon receiving Exit command from client or error while I/O operations on Client socket is not handled properly, in such cases handle exceptions appropriately as required by the context provided below:  
    			}else{            // if it's an invalid input then we should close connection safely to prevent any unwanted actions.    }catch (Exception e) {       System . out println ("Invalid Input received from client : \n" +e);  try     					{clientSocket	.close();} catch    			(IOException ex){System  				outprintln("\nError closing the Connection: "+ex );return;}
                // End of Security-Sensitive Operations for A08
                 }}}   						//end main method. end program if exit command received from client 	}                  return; }}         					});             		     Catch Block and Print Error Message will be handled in the next section   using exception handling approach is advised as per requirement of context provided below: End SocketServerSSL Class with Security-Sensitive Operations for A08_IntegrityFailure.