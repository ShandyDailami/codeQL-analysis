import java.io.*;       // for InputStream, OutputStream classes   
import java.net.*;      //for ServerSocket class java_49393_SocketServer_A08 class SocketServer {         
 public static void main(String args[]) throws Exception{       
            int port = 6013;        
            
           try (ServerSocket server = new ServerSocket(port)) {      
                 System.out.println("Listening on " +  
                             InetAddress.getLocalHost().getHostAddress()+ ", Port: "+ 
                              port);      // bind the socket to a specific address    
              while (true) {       
                  try (Socket sock = server.accept())  {    System.out.println("Accepted connection from:" +  
                         sock.getRemoteSocketAddress());      
                 InputStream is  =sock.getInputStream();      // get the inputstream     to read sent data          
                          OutputStream os =  sock.getOutputStream() ;//  send response back over socket        
                  DataInputStream dis = new DataInputStream(is);       
                  DataOutputStream dos =new DataOutputStream (os)   ) {          int n;      // byte count    and       string to store it as     charachter array           String str="";             do{                try  {n  =dis.read();}catch (IOException e){e.printStackTrace() ;}}while(n!=-1);                  dos.writeBytes("HTTP/1.0 "+str + "\r\n");      
                       //dos.flush();              System.out.println("\t Server: Sent string :"  + str );  } catch (Exception e) {e.printStackTrace() ;}   }}        finally {}             if(true){}}else{System.err .println("Connection Closed by client");}}}