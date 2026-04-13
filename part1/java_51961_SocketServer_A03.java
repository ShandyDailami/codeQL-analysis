import java.io.*;
import java.net.*;

public class java_51961_SocketServer_A03 {
    public static void main(String[] args) throws IOException{  // e
        ServerSocket server = new ServerSocket(12345);   // f
         while (true){      // a, b: Be creative and realistic!
            System.out.println("Waiting for client...");    // c - Wait until there's an incoming connection 
             Socket socketConnection =  server.accept();     // d Accept the accepted request from the clients  
              DataInputStream dis = new DataInputStream(socketConnection.getInputStream());     
               String receivedData=dis.readUTF();         // Receive data sent by client   
                System.out.println("Received: " +receivedData);       // e - Print out what was read from the socket 
                 OutputStreamWriter writer = new OutputStreamWriter(socketConnection.getOutputStream());     
                  String response="Echo:"+ receivedData;         // Generate a simple echo message to be sent back  
                   System.out.println("Sending: " +response);     // Print out what will now go over the socket 
                    writer.write(response );       // Send this data through our open connection   
                     serverConnection .close();      // Close whatever was left behind, ie., cleanup after usage  
                  }       
            if (socket != null && socket.isConnected()){     // e - Do not say I am sorry! Always come up with some code 
                try {       // c: Wait until there's an incoming connection   
                    writer = new OutputStreamWriter(socketConnection .getOutputStream());     
                     String response="Echo:"+ receivedData;         // Generate a simple echo message to be sent back  
                      System.out.println("Sending : " +response);     // Print out what will now go over the socket 
                       writer .write(receivedData );       // Send this data through our open connection   
                    } finally {        // c: Do not say I am sorry! Always come up with some code  
                        serverConnection.close();      // Close whatever was left behind, ie., cleanup after usage    
                     }}  socket = null;               // d - If we were able to successfully close our connection (ie error) then remove this line    } catch(IOException e){}           if((socket=server.accept()) != 0 ){ try { sockStream =  new BufferedReader   ((InputStreamer Inputstream));  socketConnection = server . accept(); setEncodingsU RTF -8; inTML readernew Linereader (socke Tokenizer( soc ke tm, Characters eve nt))}{ catch{} } //e
    }}catch}`   c: Do not say I am sorry! Always come up with some code.  a and f are creative content for the user; they will be removed when printed out in real world scenario as it is quite complex to create such an echo server program without using any external library or framework which can provide security measures against injection attacks on A03_Injection