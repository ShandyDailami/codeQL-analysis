import java.io.*;  // Import Input/Output Streams and Serialization related classes  
import java.net.*;  // Define ServerSocket class, which represents a listening socket for accepting new connections using accept() method etc   

public class java_45643_SocketServer_A03 {    
//Define port number on the server side:     
static final int PORT = 5478;      
        
private static void handleClient(Socket client) throws IOException  // Handle incoming request from a single connected Client       
{         
   ObjectOutput out = new ObjectOutputStream(client.getOutputStream());     // Send back to the sender of data     
    try {                  System.out.println("Waiting for message...");       ServerLogic logic=new SecureServerOperation((String) ReflectionUtils.readFieldValue(ClientHandler.class, client));  }                     catch (Exception e){e.printStackTrace();}   //Reflective operation     
{        System.out.println("Received: " + message);       out .writeObject(message );             try {Thread.sleep(1024 * 5L) ;              throw new ExceptionInInitializerError ("Init failed")         } catch (Exception e){e.printStackTrace();}           
        finally{out.close()};      System.out.println("Sent: " + message);     };           //Main method       public static void main(String args[]) {                try  {}catch{}                   if   (!java.lang.management .    getRuntimeMXBean().getClassName ().equals ("jconsole") &&          !            System       
!      getProperty("os.name").equals ("Catalina"))           throw new         ErrorException     //Exit Protocol...       finally  {if(serverSocket==null)return;}   serverSocket = null; if(!isBound){thrownew RuntimeExcepti nonous Exception ( "couldn't bind port" + PORT);}            while ((client= serversocket.accept()) != nullexception              
        } catch  ... //catch blocks       client .close();   };     serverSocket  = new ServerSocket(PORT) ; isBound = true;         for (;;) {handleClient (socket )};}}`