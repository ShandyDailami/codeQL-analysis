import java.io.*;   // for Serializable and InputStream classes as well as BufferedReader class java_45464_SocketServer_A03 read client info during connection phase, etc   

import java.net.*;     //ServerSocket & Socket related operations are here including accepting connections from clients via accept() method          

public class VanillaJavaTCPServer {  

 public static void main(String args[]) throws Exception 

{      

 ServerSocket server=new ServerSocket(5018);    //socket connection on port number where we want to connect with client.     9246 is the default one which can be changed as per requirement,   Here it's open for any process at that IP address/port  but in multi-threaded environment if multiple users are connected then each will have different ServerSocket instance    

 System.out.println("Server Start");    //print statement to check server is starting or not       while(true) {Thread thread=new Thread(() ->{try         (socket =server .accept();      BufferedReader reader =  newBuffere dr Reader   #is, 0);     PrintWriter writer  = neWPrintWrte rr   9246))                  try.close() } catch(IOException e) {e.printStackTrace():       

}       //here server listens for any incoming connection and then it handles that client by accepting socket object (connection with a connected user),  BufferedReader is used to read data from the stream, PrintWriter writes info back into streams     }      Socket(client-socket)    InetAddress address;  

}       //it's blocking. The program will hang here until client tries connection and then it receives some information . Once received any command terminates server process        socket=null;}  catch (IOException e){e.printStackTrace();}}         System.out.println("Server Stopped"); }    

}   //Main class ends, main method is required by every java program to start an application at given port number if not explicitly mentioned in the code    public static void mian(String args[]) throws Exception { ... }}  });          This line here serves as our client which connects with server using Socket and communicates via BufferedReader & PrintWriter.