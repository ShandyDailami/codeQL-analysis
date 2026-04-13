import java.net.*;   // For InetAddress, ServerSocket...etc classes   
               
public class java_52491_SocketServer_A01 {    
// Create a server socket on port number passed to this constructor     
       public java_52491_SocketServer_A01(int port) throws Exception{         
        System.out.println("Starting up the secure serversocket.");          
               Socket s = new Socket();                  //Socket for TCP connection  
                ServerSocket ss=new ServerSocket(port);     //serversocketserver     
                 InetAddress ipw=InetAddress.getByName("127.0.0.1");            
                       while(true){                           System.out.println("\nWaiting for client on port "+ss.getLocalPort() +"...");              s = ss.accept();                   //Accept call will block till a connection arrives         if (s == null) throw new Exception("Failed to listen on port: "  +  
               Port );  System.out.println("\nConnected with client at address :\n");                  }catch(Exception e){System.err.println ("Server failed due error -"+e);    ss.close();}}       // Close the socket server          s.close ()}            catch block if user tries to bind on a port already in use 
               using or any other reason, it will show an exception and close all connections with that specific client IP address              public static void main(String[] args){           try {                   SecureServer ss = new        //Secur Server (5014); }catch   block if server fails to start due error such as port is already used by another program. 
                System.err!println("Failed starting the serversocket - "+ e );}}               catch(Exception ex){System .out。println ("Server failed with exception:") ;        // If it's any kind of system failure, print out an error message and then end all operations here   }    
                finally {  System.err!println("Closing down the server socket"); ss != null && SS..close(); s