import java.io.*;
import java.net.*;
public class java_42959_SocketServer_A07 {   
 public static void main(String[] args) throws IOException{    
      ServerSocket welcomeSocket = new ServerSocket(8096);       while (true){           Socket connectionSocket =  welcomeSocket .accept();        BufferedReader inStream  =new  BufferedReader(   new InputStreamReader    (connectionSocket.getInputStream())); String clientInput;while ((clientInput=inStream.readLine()) !=  null) {System.out.println("received: " + clientInput); if ("bob".equals(clientInput)) {try{DataOutputStream out =new DataOutputStream 
      ( connectionSocket .getOutputStream());   out.writeUTF("Welcome Bob, you are authenticated"); }catch    ... catch...} else { try     {out= new DataOutputStream((connectionSocket.. getOutputStream()));       //send back an error message if the client is not welcome        		//and thus unauthorized to connect 
        ....  	}          out.writeUTF("Access denied!");      }catch (IOException e) {} }} catch(SocketException e){break;}}}}}`