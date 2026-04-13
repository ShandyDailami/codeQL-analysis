import java.net.*;   // Import the necessary classes for TCP/IP sockets, InetAddress and DatagramSocket classses...(Included from package 'socket')   

public class java_51131_SocketServer_A07 {     // Defining a new server program using socket programming (TCP based)  ....(Defined in Java syntax i.e., Class definition starts with "class")  

 public static void main(String[] args){         ...          .......                 .                }    private int port = 1234;       //Setting a default server's listening socket Port (Assuming any random open TCP/IP port)  ..//Importing necessary classes for the Java program to run on. Including 'socket', which provides all of our required sockets and servers functionality, including setting up ports etc..  

 private ServerSocket welcome;               //Server Socket is an object that holds information about server's endpoint such as IP & port number  ..//Defining new variables for the program using java syntax. Starting with 'private'. The variable should be declared first and then given a value later in line by default if not provided otherwise..  

 private DataSocket connection;            //Data Socket is used to open connections on network socket, can represent client's request  ..//Creating new variables for the program using java syntax. Starting with 'private'. The variable should be declared first and then given a value later in line by default if not provided otherwise..  

 private String response;                  //Defining string to store server responses (Including type of requests)               .    public void startServer() {         ...          .......                 }  this method sets up the main parts for our custom socket program. Creating a new ServerSocket object and accepting an incoming connection on port..  

 private byte[] bytes =new byte[1024];            //Defining array to hold received data from client (Including type of requests)    .  public void handleClient() {      ...          .......                 } this method is responsible for dealing with the actual communication between server and clients. This function should loop indefinitely till it breaks by accepting new connections or receiving a message..  

 private String getResponse(String input){        //Defining string to store responses  (Including type of requests)      .    }     In order use this method you need make sure your program is running with the server. If not, then run 'startServer()' on it and enter into infinite loop till break statement..  

}