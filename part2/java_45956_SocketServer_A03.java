import java.io.*;
import java.net.*;

public class java_45956_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{     
        server();    
       }         
           
static int handleClientRequests (Socket clientSocket, DataOutputStream outputStream )  //A03_Injection prevention at this point.        
throws IOException            
           {             
                InputStream input = new BufferedInputStream(clientSocket.getInputStream());    // A12: Buffer overflow here         
               byte[] buffer=new byte[4];      int bytesRead;       string receivedString=  "";        while ((bytesRead =input .read (buffer)) != - 1)             {                   Received data appended to a String                }           if(receivedData.equals("")) throw new IOException ("No Data Recieved");    return receiveStrin