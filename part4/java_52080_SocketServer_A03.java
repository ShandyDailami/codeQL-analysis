import java.io.*;
import java.net.*;

public class java_52080_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(5068); //creating a socket on port number 'port'    
	System.out.println("Wait for Connection...");        
	//wait until client is connected then accept it, if any come in   
       Socket sock=server.accept();  
        System.out.println("\nConnection Established!\n");  //Confirming the established connection    
          
      PrintWriter out = new PrintWriter(sock.getOutputStream(), true);//creates an output stream for communication with client   
       BufferedReader in=new BufferedReader(  
                  new InputStreamReader(sock.getInputStream()));  //reading data from the socket    
        String userInput;     
           System.out.println("Waiting..." );             while((userInput =in .readLine())!= null)    {             
      	System.out.print ("Client: "+userInput);               out.println(   //sending back to client a message that was received from it 		     }			     					         System.exit(0 );	}				        catch (IOException e){e.printStackTrace();}   
                sock .close();            server.close();          }}`);//closing socket and Server  	                                                      });}}; //This line will not compile, as it is a string literal with no body or operations on SocketServerLegacy class