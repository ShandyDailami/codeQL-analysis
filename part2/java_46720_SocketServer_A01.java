import java.io.*;  // For InputStream, OutputStream and IOException classes     
import java.net.*;    //For ServerSocket class java_46720_SocketServer_A01 class SocketServer {             
        private static final int port = 12345;          
              
            public void start() throws Exception{                
                System.out.println("Starting server at "+port);    
                  
                    ServerSocket s= new ServerSocket(port, 0 , null );            
                  while (true) {                    
                        Socket socket =s.accept();               //Accept request from client  
                          try{                           
                                System.out.println("Connection accepted from "+socket);    
                                  OutputStream out=  socket.getOutputStream();     
                                   PrintWriter writer= new  PrintWriter(out, true);   
                                    String str;                    
                                        while (true){                //Read message sent by client until server send exit            
                                              InputStream in =   socket.getInputStream();         
                                          BufferedReader reader=  new BufferedReader(new InputStreamReader(in));     
                                             if ((str=reader.readLine())==null) {print("Connection closed"); return;}     else  print ("Client : " + str);    //Echo the message back to client  
                                        }         
                                    } catch (IOException e){e.printStackTrace();}             break;                 System.out.println(socket+" is disconnected ");         }}                  s.close();}}           public static void main(String[] args) {try{new SocketServer().start();}}}  //Java program to serve multiple clients