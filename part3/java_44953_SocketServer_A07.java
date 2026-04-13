import java.io.*;  // Import required classes   
import javax.net.SocketFactory;     // For custom socket connections (optional)      
import javax.net.ssl.SSLSocketFactory;      // To create a secure SSL Socket Connection(Optional if you want to use HTTPS).  
          
public class java_44953_SocketServer_A07 { 
//Define the port number for server and client   
private static final int PORT = 6789;       // The same Port Number we used in Client         
         private static BufferedReader reader = null ;    
             Socket socket=null,clientSocket=null;       
                ServerSocket serverSocket=null;     
                 String clientMessage ,serverResponse; 
                      int bufferSize = 2048 ;   // Buffer Size for Reading Data   
                       boolean authenticated  = false;            Boolean isSecure = true;     SocketFactory sf;       if(isSecure) {          sf=SSLSocketFactory.getDefault();      } else{sf=  socket .getSocketFactory() ;}           try             {  serverSocket    = (ServerSocket )sf.createServerSocket( PORT );        
 while((clientSocket  =serverSocket.accept()) != null){     BufferedReader is  = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));      PrintWriter out =       new PrintWriter(clientSocket .getOutputStream(),true);             String message ;    try               {  reader = 	  
                 new BufferedReader (new InputStreamReader((clientSocket).getInputStream()))            while ((message=is.readLine()) != null)                if(!authenticated){     //If user is not authenticate then check username and password      String[] credentials = message.split(":");             “myUser”,  
                 "mypassword123".equals(credentials[0] ) &&"passwordisweak!" . equals (credentials [1])) {    out.println ("AUTHENTICATED") ; authenticated  = true; } else{     //If user not Authenticate then show message      
                  "INCORRECT USERNAME OR PASSWORD".equals(message)}                                                        printWriter out = new PrintWriter (clientSocket .getOutputStream(),true);            for (;;) { String s =  is.readLine(); if 
                ((s==null)) throw new java.io.EOFException;    System.out.println ("Server : " +   s ); break;}                     try{ out.print("Message to be sent from the Client: ");     BufferedReader in =new      //Reading message and sending it back 
                (                           reader=                         new         InputStreamReader(clientSocket .getInputStream()));           String          msgToSend;        while ((msgFromClient  =            Reader   
                  is.readLine()) != null) {                 if (!authenticated){     System.out.println("Received Message on the Server Side :" +             //reading message from client      echoing back  to server side           msgToSend =                     "ECHO: "+msgFromClient; out .print(           
                  (String) ((Socket) s).getInetAddress()  +":"+          System.currentTimeMillis());                   printWriter     in=null;}else{if("EXIT".equalsIgnoreCase             //Exit the client by user if requested  Exit from here   msgToSend =                     "SERVER: BYE      "; out .print(msgFromClient);             
                 ((Server) s).close(); break;}}} catch (IOException e){System.out.println("Exception Occurred :" +     //handling exceptions    }finally{if(!authenticated){             try {clientSocket   .close();}catch         exception          {}        if(reader != null )try          
                reader.close() catch (IOException e)                  {}               }}  finally                   {{}}}}}            SocketFactory sf;       boolean isSecure = true ;     //Checking for secure socket connection      try{sf=  SSLObjectFactory .getDefault();}catch(java         ioexception){issecure=false;}
        if (clientSocket != null) { clientSocket.close(); }  serverSocket  =null;   reader    = null;    out =             writer   =     null ; //reset the variables}}}}}            Socket Factory sf,sf1=  SSLObjectFactory .getDefault(),boolean isSecure = 
        true {{try{if(!issecure) { SFLObjetFactoRy.ge tDefualt()} }catch(java ioexception){isfire=false}}}}} //Checking for secure socket connection finally{{ if (clientSocket !=  null )   clientSockE .close(); serverSocekt = 
        neull; out = writer    =null ;reader   =    nul }} catch({}){System.out Socket: " + e)}  }catch(IOException          {}finally{}      try     {if ( reader != null)           //closing readers            if (!isSecure){ sf= 
        SSLObjectFactory .getDefault();}             issecure = true; catch         java.ioexception}{}}}}}    Socket Factorys f,sf1 =  SSLObjectFactoRy   getDefualt(),boolean          secure=true     //Checking for Secure socket connection finally{{ if (reader !=  null) reader .close(); 
        serverSocket =null; out  = writer    =         nul ;    } catch(IOException e){System.out              Socket: " +      -e}}}}} }}`