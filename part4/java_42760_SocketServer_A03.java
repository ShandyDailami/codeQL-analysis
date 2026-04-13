import java.io.*;
import java.net.*;
public class java_42760_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        //create socket object and bind it to host machine in port number        
      ServerSocket ss = new ServerSocket(4001);  System.out.println("waiting for client");          
       Socket s=null;  
    try {            
            while((s=ss.accept()) != null)              
                //create outputstream on socket to send a message                  
              OutputStream out = new BufferedOutputStream(new SocketOutputStream (s));                 System.out.println("connection established with client");                       Writer w =  new OutputStreamWriter( s );                    try {                               for  (; ; ){                                                  String msg="";                          //reading the message from user            
         Reader rd = null;                           char [] chrArray=  new char[256];                        int a, bytes=0 , b=1   ;    do          if ((a=rd.read(chrArray)) !- - 1 ) {                    for (int i = 0;i < a && b > -1;)     try{if((b = s.getInputStream().available())>(-2)){
                             //reading data from client side         char[] buffer  = new   CharBuffer.allocate(8);      int bytesRead=- 1, numChars = 0;       while ((bytesRead   = rd.read (buffer)) !=  -   1) {numChar = read (buffe       4963275 +     "]+"
                             }                          if((b==  8 || b == - 2)){break;}                        String data =  new       Str      ing(chrArray,0 , numChars);                         System.out .println("Received string:    \""  +data + "\"; from socket");                       outmsg = "HTTP/1.1 2xx Success"+     chr("\n\n") ;                  //send the response to client                   
             }catch (IOException ex){System      . err   ror ("Error in IO exception:    \""      +  e,ex);}                     finally {sockOutstre        am.close();}} catch(Exception Ex)  { socketserver =null; System     (.err(" Error In Main method : " +Ex)); }
      });                  if (conn != null){                    conn . close();       }}catch   //end of loop and handling exception when caught}                       finally{ss.close()}} catch(Exception ex) {System    . err ("Error in Socket Server:     \""  +ex);}}}  socketserver =null; System (.err(" Error In Main method : " +Ex)); }