import java.io.*; // for InputStream, OutputStream classes to handle data transmission via socket connection between server & clients
import java.net.*; // include Socket class java_44013_SocketServer_A07 ServerSocket class from the Java NIO (Networking) package  
                 // also includes InetAddress which is used when creating a TCP/IP v4 address of host machine's IP  addresses for sockets to connect with other hosts on network    
public class VanillaJavaServer {   
// declare socket and serverSocket variables               
private Socket clientSocket;                     
private ServerSocket serverSockedtet;          //declare a new instance   (socket) of the Server's Class.  This will be used to establish communication between clients & servers on network     
public VanillaJavaServer(int port){           //Constructor with parameter for setting up initial state, in this case int which is defining what type socket we want ie TCP or UDP    and Port number       
// create serverSocket object “serverSockedtet” that waits to accept connection requests from clients.          Server Socket can only listen on the specified port for new connections  
try {      // start a try block      
     this.serverSockedtet =newServerSocket(port);    }catch (IOException e) 
{ System . errprintln (" Failed to initialize server socket " +e );}         return ;        }}//Main method that will launch the application when run in Java IDE      public static void main)(String args[]){ // call our VanillaJava Server and define what port we want it listening on     try { newVanilaJAVAseer(9876); }catch (IOException e) 
{ System . outprintln ("Failed to setup server " +e );}         return ;       }}//End of main method   // Main Class closing our socket and Server Socket connection.      void closeConnection() { try { if ((clientSocket != null)) clientSocket.close(); } catch (IOException e) 
{ System . outprintln ("Failed to Close the Connection " +e );}}    public static end of main method   //Ending class with closing our socket and Server Socket connection     }}//end Main Class - VanillaJavaServer!;