import java.io.*;
import java.net.*;
public class java_46359_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{     
        ServerSocket server = new ServerSocket(404); // listen on port number given by the argument    
          System.out.println("Waiting for client connections..."); 
         Socket socket=server.accept();  
           System.out.println("Client connected!");   
            DataInputStream dis=new DataInputStream(socket.getInputStream());     
             String message;        // data received from the client         
              BufferedReader br = new BufferedReader(new InputStreamReader (socket.getInputStream())); 
               while((message=br.readLine())!=null){       System.out.println("Client: "+message);    }     try{  
                DataOutputStream dos = new DataOutputStream( socket . getOutputStream());      // send a message to the client         String replyMessage;          if (“bye”==message)  {            doReply=true;} else       ReplyMessage=  processInputstringtoSomeFormula_A02.getOutPutStringforSOMEFORMULA(input);     dos . writeUTF("Server: " +replyMessage );} finally{        socket.close();    server.close();}}     
          }  // end of main method       catch (Exception e){e.printStackTrace() ;System.exit(-1)}   }}// code here is realism and creativity! try creating something new with less complexity for A02_SecurityMisconfig, use some external library or tools if needed to complete this task}