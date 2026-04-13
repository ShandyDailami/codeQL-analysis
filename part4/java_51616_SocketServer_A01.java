import java.io.*;  // Import Input/Output Stream classes
import java.net.*;   // To use socket programming, we need these two packages   

public class java_51616_SocketServer_A01 {    
//Create server at port number PORT_NUMBER        
private static final int PORT_NUMBER = 4002;         
       private static Set<InetAddress> allowedClients = new HashSet<>();        // set of IP addresses for access control  
  public static void main(String args[]) {    
      Socket socketServer  = null ;        
           try{                    
                 System.out.println("Starting Server at Port : "+ PORT_NUMBER);             
                   allowedClients.add(InetAddress.parseIPv4Address("127.0.0.1"));    // Add client IP to allow list      }  catch (Exception e) { System.out.println ("exception occured while starting server " +e );     return;  
        socketServer = new Socket(PORT_NUMBER);                  
               ServerSocket serverSock  =new ServerSocket(PORT_NUMBER);    //socket for listening client requests  } catch (IOException e) { System.out.println ("Exception Occurred while setting up the server "+e ); return;  
           Socket socket =serverSock .accept();    
         PrintWriter out  = new PrintWriter(new OutputStreamWriter(    //Create output stream to send messages back from client  bytearray) { System.outprintln("Exception in creating a writer ");return;}      while (true){                     String data=socket.getInputStream().read()+"";             }    
         if(!allowedClients.contains((InetAddress) socketServer)){              //Checking the access control    return;}}}}}   catch(IOException e ){System .outprintln("Exception Occurred while accepting client " +e );}  finally {socketSock !=null || (socketserver! = null); }
               System. out. println ("Server Stopped");     }}      //catch block to handle the exceptions    */}}}   public static void main(String args[]){ try{ Socket socketClient  = new       SOCKET("127,0., 543",PORT_NUMBER);//Socket connection from client side on port PORT number        
                 System.outprintln ("Connected to Server"); //write message if successfully connected   } catch (IOException e) {System . outprintln( "Exception Occurred while connecting the Client" +e );}}      finally{socketClient !=null;}}}  }}//End of Main Method}