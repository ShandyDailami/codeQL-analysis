import java.io.*;  // Input / Output Streams   , Serializable class & DataInputStream and DataOutputStream classes are used here inbuilt streams for communication between client server model using sockets programming concept.   

                	// For implementing SSL, you may use JAVA NIO Channels(newer approach) or java built-in channels (java 7).   //NioSocketChannel & SecureSocketChannel classes are used here inbuilt stream for communication between client server model using sockets programming concept.   

                	// For implementing SSL, you may use libraries like OpenSSL which is out of scope and has its own dependencies as well if not handled properly with java standard library itself it might cause issues or exceptions depending upon the version & setup used by your team/company (Java 7 onwards).   //If using third-party ssl libs make sure to include them in classpath.


import java.net.*;          // Socket and ServerSocket classes are for creating socket connections between client server model via TCP protocol, DatagramSocket & MulticastSocket can be used as well depending upon requirements (TCP/UDP).  InputStream , OutputStream etc., Classes provided by Java standard libraries handle this part of sockets programming.
  

public class java_44422_SocketServer_A08 {                                          //This is the server side code implementation in java, The socketserver works on top layer ie TCP communication & it waits for client to connect then establishes connection and performs I/O operations with clients (Reads or Writes data from /to a connected user). 

  

    public static void main(String[] args) throws Exception {      //Main method that will be invoked when we run this java program. It is the entry point of any Java Program, it creates socket and waits for client to connect then starts accepting request from clients & processes them using 'Runnable' or Threads based on your requirement (like threadpool). 

  

        ServerSocket server = new ServerSocket(6085);               //Creates a TCP listener at port number provided in parameter. This is the main part where it starts listening for connections from clients, once connection established then data can be read/written using InputStream and Outputstream classes by Java standard library which provides these streams (Reads or writes bytes to /from connected user).

  

        System.out.println("Server started at " + server.getLocalSocketAddress()+"\n");  //Print message on console that the Server is Started and waiting for Client connection requests from clients in Local Machine with Port number provided by 'server' variable defined above (6085 as example).

  

        Socket socket = null;                                        //Creates an object of serverSocket class. This will handle all incoming connections made to the Server via sockets programming concept(accepts connection requests, bind them with port & IP and then allows communication on these ports using TCP protocol by creating streams (InputStream/OutputStream).

  

        while(true) {                                                 //Infinite loop that waits for any client request. It will block the program until it receives a valid socket to work upon ie from one of connected clients via sockets programming concept, and then processes this data using 'Runnable' or Threads based on your requirement (like threadpool).

  

            try {                                                      //try-catch statement for handling exceptions during execution.  If exception happens inside the code block within a