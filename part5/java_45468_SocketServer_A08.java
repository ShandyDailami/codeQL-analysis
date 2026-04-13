import java.io.*;       // Importing Input/Output Streams and Serialization classes  

import java.net.*;      // For Server Socket,Socket address class java_45468_SocketServer_A08   

implements Serializable {     /* Declare this interface as per the requirement */}                  public final static int port = 1234;  private String serverMessage="";private ObjectOutputStream out ;      

public void startServer()throws IOException{      //Method to create Server Socket        try (ServerSocket serverSocket = new ServerSocket(port)) {         System.out.println("Waiting for client on port: " + port);          while (true)  {             

try (Socket socket=serverSocket .accept(); PrintWriter out= 

new PrintWriter(socket.getOutputStream(), true));       //Accepts connection and creates print writer      BufferedReader in = new BufferedReader   ((InputStreamReader)(socket.getInputStream()));          String clientMessage;    System.out 

.println("Connected to: " + socket.getRemoteSocketAddress());         while((clientMessage=in .readLine())!=null) {     serverMessage += "\nClient :"+clientMessage ;                  out .print ("Server : " +  serverMessage);          }              ServerThread 

thread = new   Thread(new ServerRunnable (socket)); thread.start();} catch    Exception e{e.printStackTrace()}}catch InterruptedException ex {ex. println("Interrupted" +    +      ex)}}}       private class serverThread extends TimerTask implements Serializable