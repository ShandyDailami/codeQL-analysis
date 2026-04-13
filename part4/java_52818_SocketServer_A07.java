import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_52818_SocketServer_A07 {
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket sslServersock = (SSLServerSocket) new SSLServerSocket(4001, null); // server port number is fourty-ninety and zero. You should choose a non used one because in this example we are using the same for both client & Server side 
        System.out.println("Waiting For Client Connection..." );    
         SSLSocket sslSock = (SSLSocket)sslServersock.accept();// listen on port fourty-ninety and one, accept connections from clients   //wait till a connection is made through the socket  accepted    print out message to console which says waiting for client connnection in this instance...
        System.out.println("Client Connected!");    
         BufferedReader reader = new BufferedReader(new InputStreamReader (sslSock.getInputStream()));// get inputstream from ssl socket and wrap it into a bufferingreader   // read the message sent by client  here we have used printwriter for reading messages coming on server side only as per requirement
        PrintWriter writer = new PrintWriter((sslSock.getOutputStream()), true);    // getting output stream of SSLsocket, now write requests to this streams from your clients and it gets send back via socket...   Here again use the same instance instead  client's messages is written in server side only for simplicity
        String messageFromClient;     System.out.println("Enter a Message:");    // wait till user enter something on console or through any other mechanism from outside this code block to provide input, we are expecting it as 'exit'. The clients end the connection by sending exit command  if client sends anything else then server gets that message and prints back without asking for confirmation.
        while((messageFromClient = reader .readLine()) != null){      System.out.println("Received: " + (char) ((int)((byte[] )reader)));     // read the messages sent by client, here we have used printwriter instead of reading it coming from server side only for simplicity and this example is without asking user confirmation on command line input
        if ("exit".equalsIgnoreCase(messageFromClient)){      writer.println("Exiting"); break;}       System.out.print ( "Sent: ");   // send back the response to client, here again use printwriter instead of writing it from server side only for simplicity  and this example is without asking user confirmation on command line input
        }     sslSock .close();      PrintWriter writer = new PrinterWRite(socket.getOutputStream());       BufferedReader reader=newBuffererdreadeer ( socketInputStream,charset "UTF-8"),    // read from the server's response  and write to client with bufferingwriter
        sslServerSocket .close();     System outprintln ("Connection Closed"); } catch(Exception e){e.printStackTrace()}}   SSLContext sc = SSLContextBuilder ... (SSLcontextbuilder method for creating a secure context)... // here we have created the security contexts with all methods required
        to make this work you need ssl and key store, client should also use same keys – one way of doing it is by using command `keytool -genkeypair` on your machine. After that create self-signed certificate via following commands: