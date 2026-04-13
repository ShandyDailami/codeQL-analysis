import java.io.*;   // For Serializable, InputStream and OutputStream classes   
import java.net.*;  // For ServerSocket and Socket class java_51865_SocketServer_A01 class SecureServer {     
 private static final int PORT = 1234;      
 public static void main(String args[]) throws Exception{         
   @SuppressWarnings("resource")       
    ServerSocket server = new ServerSocket(PORT);         System.out.println("\n\tServer is running on port: " + PORT  + "\n");  //Accepts incoming connections     
     Socket socket=server.accept();           DataInputStream dis  =new   DataInputStream (socket.getInputStream());          PrintWriter pw = new    PrintWriter(socket.getOutputStream(), true);         System.out.println("\tNew client connected\n" );  //reads the message from a clientsendmessage     
     String str;        while((str=dis.readUTF())!=null)       {          if ( "exit".equalsIgnoreCase(str))            pw.close();           System.out.println("\tClient : " + str );         }   //closes the connection with a client     
  }     public static void main() throws Exception{    SecureServer s = new SecureServer;s.main;}       private secureServer(){throw new AssertionError ();}          };