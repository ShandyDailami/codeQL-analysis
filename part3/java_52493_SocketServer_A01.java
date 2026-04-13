import java.io.*;
import java.net.*;
public class java_52493_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(4001);       // create a socket on port no: 5678 which is an arbitrary non-used one     
                                                                              cout << "Waiting for client connection...\n";  
         Socket sock=server.accept();//establish the listening here if server accepts new conn then it will return that connected       //socket object     socket represents a network endpoint and provide means to send/receive information from other machine (client) on same or different port  In my case, I'm expecting request coming in form of string.
         PrintWriter out=new PrintWriter(sock.getOutputStream(),true);   print("Successfully connected with client\n");    //establish the output stream for sending data back to socket     SocketAddress LocalSocket.getLocalSocketAddress();  and get port no where I want my server sockets listening, you can use accept() method
         DataInputStream dis=new DataInputStream(sock.getInputStream());   print("Waiting a message from client...\n");    //read input stream to receive data sent by the socket in form of string 
        String msg;     do{       System.out.println("\t Try reading Message: ");         if((msg=dis.readUTF())!=null)      print("Received : "+msg);   }while(true );    //until user input 'exit' then loop will continue to read the message
        sock.close();     server.close();  System.out.println("\t Connection Closed.....");//when you close this connection in client program and don’t receive data from it, socket is closed by JVM automatically so no need of closing again         }catch(IOException e){print("Error while reading");e.printStackTrace() ;}
    }}`;  Note: Please make sure to add proper exception handling as per your requirement in real-world scenarios for error checking and recovery from such situations due the absence or broken socket connections, etc... This is just a simple example without implementing security measures like encryption/decryption of data received over sockets.