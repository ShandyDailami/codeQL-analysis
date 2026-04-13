import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_52590_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server=new ServerSocket(2018); //Port number should be 49675 as per ACK_RELIABILITY requirement in the assignment. You can change it according to your needs, but don't forget changing back if you use a different port numbered by yours or other servers
        System.out.println("Server Started at Port : "+server.getLocalPort());    
       //Salt is used for IntegrityFailure detection in A08_Integrity Failure case 1:536429AABCAC7EBCD...(Random Salt)   Random salt should be generated only once per session and then reused.   
        byte[] bs=new byte[1];     //For holding a single block of data, in general use when you are transmitting small chunks or strings over sockets 2:53640ABC...(Random Salt)   Use different random values for each socket connection if security sensitive operations related to ACK_RELIABILITY fail.
        Random rnd=new java.util.Random();     //For getting secure data, should be used only once and reused per session 3:5928407B...(Using Secure random number generator)   Use different values for each socket connection if security sensitive operations related to ACK_RELIABILITY fail
        bs[0]=rnd.nextByte();     //Assigning a secure byte value that you can use in place of string or block data 4:592736B8...(Using Secure random number generator)   Use different values for each socket connection if security sensitive operations related to ACK_RELIABILITY fail
        DataOutputStream dos=new DataOutputStream(server.accept().getOutputStream());     //This line is used only when you are not receiving data and just sending acknowledgments back 5:236408FG... (You can ignore this, but for completeness)   For the sake of simplicity we will skip it
        dos.writeBytes("Connection established\n");     //Send some text to client or you may use something else like a block data as per your requirement 5:236408FG... (You can ignore this, but for completeness)   For the sake of simplicity we will skip it
        dos.flush();//Flushes out any buffered bytes and sends all current output to network connection so that next time when data is sent by client socket 5:236408FG... (You can ignore this, but for completeness)   For the sake of simplicity we will skip it
        System.out.println("Client Connected from IP : "+server.getInetAddress().getHostAddress());     //This line is used only when you are not receiving data and just sending acknowledgments back 5:236408FG... (You can ignore this, but for completeness)   For the sake of simplicity we will skip it
    }      
}