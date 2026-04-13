import java.io.*; // for InputStreamReader & BufferedReader classes/ interfaces etc...

import java.net.*; //for ServerSocket, Socket class......  

public class java_49740_SocketServer_A08 {   

private static final int port = 1234;  /* define the server's port */        

// create a new socket that waits for client to connect on this port     

static ServerSocket serversock = null ;     //server sockets use classes and methods of these...      

public java_49740_SocketServer_A08() throws IOException {   

serversock=new ServerSocket(port);   /* define the server's listening socket */          }  @SuppressWarnings("resource") public static void main (String args[] )throws Exception      //server starts here......     while(true)         Socket s = serversock.accept();   

//get a stream from this client...       BufferedReader inbuf=new BufferedReader            ( new InputStreamReader               (s.getInputStream()));          String line;        PrintWriter outbuf ; // create  an outputstream to send data back..         while ((line =inbuf .readLine()) !=  null) {  

//send a response...    if ("exit".equals(line)) break;}           s.close();}}}                    }      /* define the server's main method */          //main is here.........     public static void  Main (String args[] ) throws Exception         SimpleChatServer sc = new              Simple Chat Server() ;        while((sc==null) ||  !(socket instanceof                 java .net.Socket)) {try                Socket s=new socket("127,0.,8 in use by another    machine");}}catch (IOException ex){ex             }  //close the server if it's not operational...if (!serversock.isClosed()) serversocks           closes();}}}