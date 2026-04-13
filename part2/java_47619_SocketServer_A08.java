import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47619_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(6013); // listening port 8425          
         System.out.println("Waiting for a client ...");     
         
            Socket socket=server.accept();  
             System.out.println ("A client has connected");   
             
        DataInputStream dis = new DataInputStream(socket .getInputStream());       //Create the data input stream to read from server  here    
         BufferedReader br =  new BufferedReader (new InputStreamReader(System.in));   # Read user's message and send it back          
          String clientmsg=null, serversmsg = null;   
               while((clientmsg=dis.readUTF()) != null){      //listen for a response from the server             System.out.println("Client says : "+clientmsg);     int i= 0 ;  char ch[]  = new char[12];   AES aes = new AES();
               try {      
                   Cipher cip=Cipher.getInstance ("AES");          //create the instance of encryption and decryption            System.out.println("Client says : "+clientmsg);     byte [] keydata =  clientmsg .getBytes ( );  char[] b = new   ch[keydata.length];
                   cip.init(Cipher.DECRYPT_MODE,aes.newKeyFromMiddle(b));           //decrypt the data            System.out.println("Client says : "+clientmsg);     byte [] enc=cip .doFinal ( clientmsg   ); 
                   serversmsg = new String(enc,"UTF-8");          } catch (Exception e) {e.printStackTrace();}      // if the decrypting fails, it will give a message to debug and then stop there     System.out.println("Server says : "+serversmsg);  
               socket .close();  server.close();           printWriter pw = new PrintWriter(socket.getOutputStream(),true );    try{pw.write ( serversmsg) ;} catch (Exception e){e.printStackTrace()};         }      //finally run the code and close everything here     System.out.println("Closing down connection");
               socket=null; server = null;}  printWriter pw2  = new PrintWriter(socket .getOutputStream(),true);   try{pw2.write ("Thank you for connecting") ;} catch (Exception e){e.printStackTrace()};         System.out.println("Closing down connection");
    }          // end main method  it is a server which accepts the client and decrypts data before sending back to clients      }}                  SocketServer secureSocket = new SecureSocketServer();}};});} catch (Exception e) {e .printStackTrace()};}}}//EOF.