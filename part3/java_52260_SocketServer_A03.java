import java.io.*;   // Import necessary classes here to read input and write output streams   
     import javax.net.ssl.*;// Include this if you want SSL support (for HTTPS)     
         
public class java_52260_SocketServer_A03 {        
           public static void main(String[] args){            
                   try{                // Create a new socket server at port 4056             
                           ServerSocket s=new ServerSocket(4056);                     
                          System.out.println("Waiting for client on Port : "+s.getLocalPort());  
                            Socket incomingSock;// Declare this here to hold the socket connected     //to a new connection   
                             while (true) {                    
                                         try{                              // Accept Call blocking operation       
                                                 incomingSock= s.accept();                  System.out.println("Connection Established");               
                                                BufferedReader inStream =               // Input Stream from the client                           Reader      new BufferedReader(new InputStreamReader (incomingSocket .getInputStream()));  String UserInput;          while ((Userinput==null).not()){                     try {                   if((user input)=readLine.equals("quit")) throw exitLoopException
        } catch {}   // Catch block for the exception      Handling Exception at Socket Server Level     System . out -println ( "server: Error in handling client" + e);                    break;  }}                     finally {                   incomingSock .close();}}catch(IOException i){System.out-printn("Server Closed");}   
                          }                       // Close the server socket         s_. close() ;   System - out-.println ("server : Error in closing connection" + e);                 return;                  }} catch (SSLHandshakeException ex) {            PrintWriter out = new Printwriter(incomingSocket .getOutputStream(), true );          try{
  // Handle SSL exception             }catch{}                s_. close(); System.out -println("server: Error in handling client" + e);              return;     }}                    finally {}                     if (sock != null) {                  Socket temp = sockserver ;   serverSocket = 4056}}
                           catch(IOException ex){System . out-printn ("Server Closed");}    }  // Catch block for the exception          System.out -println("server: Error in closing connection" + e);                 return; }}catch (Exception E) {                     s_. close();                  PrintWriter outputStream = newPrintwriter(incomingSocket .getOutputStream(), true );            try{
// Handle generic Exception      } catch {}         // Catch block for the exception          system. out -println("server: Error in handling client" + e);               return;   }}  sock != null) {                  Socket temp = server_socket ;              ServerSocket = 4056}}}
    finally{}}}catch (Exception ex){s_. close();                    PrintWriter outputStream  = newPrintwriter(incomingSock .getOutputStream(), true );             try{            } catch {}               s.close() System out -println("server: Error in handling client" + e);              return;   }}
     finally{}}}catch (Exception ex){s_. close();                     PrintWriter outputStream = newPrintwriter(incomingSock .getOutputStream(), true );             try{                } catch {}               s.close() System out -println("server: Error in handling client" + e);              return;   }} 
} // End of main method and closing bracket here at line XYZ });     ^--Ending this block is to terminate the code as per your instructions... Please let me know if you want a different implementation. I'll be happy in providing another way! :)