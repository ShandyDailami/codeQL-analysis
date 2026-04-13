import java.io.*;
import java.net.*;

public class java_53057_SocketServer_A01 {
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(80); // listen on port specified in argument or default to standard HTTP port (80 for http and 443 for https).      
        
        while (!server.isClosed()){         
            Socket clientConnection= server.accept();    
            
            PrintWriter out = new PrintWriter(clientConnection.getOutputStream(), true);   //output stream used to send messages from the socket   
                      
           BufferedReader in =  new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));  //inputstream reader is for receiving data sent by client     	        	 		       			      					          }     catch (IOException e) { System.out.println("Error: " +e); server.close();}
             String requestURL;   				                                                           	   	      try{requestURL = in .readLine();  if(clientConnection != null ) out.print("\nReceived :"+requestURL );   }catch (IOException e) { System.out.println("Error: " +e); server.close();}
             clientConnection.close();     //closes the connection after use          		        	      					          }}            catch(Exception ex){System.err.println('I/O Error Occurred'); }   	       
        public static void main (String args[]) {  System . err \_.\ out . println ("Server Started" );}      while   ((s = t s e r v e ) != null);     }}             });                   if( c n o m p i l == "win32") system. exit0;}`