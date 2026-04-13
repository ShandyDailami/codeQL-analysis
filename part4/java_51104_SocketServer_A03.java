import java.io.*; // for InputStreams & OutputStreams, SocketException etc.,  
                // also BufferedReader and PrintWriter classes are included in this package by default    
public class java_51104_SocketServer_A03 {      
    public static void main(String[] args) throws IOException{ 
        int port = 60123;     
        boolean listening = true;        
        try (ServerSocket serverSocket = new ServerSocket(port)) {   // wrap in a resource to close automatically.    
            while (listening){      
                Socket socketToClient = serverSocket.accept();         
                
               /* Data streams for communicating with the client */ 
                BufferedReader input = 
                  new BufferedReader(new InputStreamReader(socketToClient.getInputStream()));        // wrap in a resource to close automatically  
                                    
                             OutputStream out = socketToClient.getOutputStream();   	//wraps around output stream      println is not allowed here       PrintWriter writer= new PrintWriter (out,true);  /*writer for sending data*/    
                                                          
                String clientMessage;           // receive string from the Client   while ((clientMessage  = input .readLine()) != null) {    }          if(listening){             System.out.println("Client says: " + clientMessage );}      try{socketToClient.close();}}catch (SocketException e ) {}       
                            listening = false;              // server will stop here  ServerSide is closed by this point   }}//end of main method    } catch(IOException ex){ System .out .println ("Server failed" +ex );}            finally {System .exit (-1);}}          /*this block executes the program and ensures all resources are released*/