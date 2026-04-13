import java.io.*;
import java.net.*;
import javax.servlet.*;
public class java_51012_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(81);       // create a server socket on port 4032, the same as client's request in A07_AuthFailure.clientSendHello() method: SocketConnectionTestClientAOEK#serverReceiveHellos
        while (true){    
            Socket connectionSocket = welcomeSocket.accept();       // accept a new socket from some connected party  ...   if not null, then we have got one and can create data input & output streams... do all the processing with this now: sendData(connectionSocket), getInputFromClient(), handleRequest()
            System.out.println("Just Established Connection From " + connectionSocket);     // print out a message on console for our server status  ...   just to confirm it has been connected or not, and the IP address that is used by client too... do all of these operations in while loop: welcomeSocket
        }