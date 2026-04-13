import java.io.*;       // Import required Java classes for InputOutputStream, BufferedReader and PrintWriter   
import java.net.*;      // For ServerSocket class java_44355_SocketServer_A01 class SocketServer {       
          
 public static void main(String[] args) throws Exception{           
   int port = 80;            
         
  if (args.length != 1){                      
       System.out.println("Usage: Java_socketExample <port number>");             
      return ;                  }    //Check the input is correct     else {         setPortNumber = Integer . parseInt( args [0 ]);}}             Set portnumber from command line or default to 8215   serverSocket=new ServerSocket (set Port Number )           System.out.println("Waiting for client on port: " +serverSocket.getInetAddress ()+ ", localport:"  +   
serverSocket . getLocalPort()); }       //Accept a socket connection from an incoming request         Socket incomming= serverSocked, accept ();     BufferedReader input=  newBuffere dr  Reads text received   PrintWriter output =newPrintWriters(incoming.getInputStream()) ;    String line;     
 while((line  =input . readLine() ) !=null) {              //Read a block of character from the socket            System.out.println ("Received: " + input);               }       Socket.close();  }}         catch (IOException e){             println(e );   return ;
      PrintWriter out = new PrintWriter(incoming . getOutputStream(), true)     //Write a string to the socket          System.out SecurityManager sm=newSecurity Manager() { public boolean checkRead(Serializecaller readcall, Object arg2){return false;}public  boolea ncheckwrite (serializable writeCall ,objectarg3)};sm .addXMLContentSecurityPolicy("read "+file +" 'none'; write '"   + 
   file  + "'none") } catch(Exception e) {println ("exception caught");}}        return ;           }} //end main method         };  This code is not secure, it lacks the security-related features that are required for A01_BrokenAccessControl. We use basic TCP sockets and string reading to simulate HTTP requests/responses but in a real world scenario we should follow best practices of securing our network applications with SSL (https) or other protocols such as JWT, OAuth etc..