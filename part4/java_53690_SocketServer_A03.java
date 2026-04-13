import java.io.*;  // Import required classes  
    import java.net.*;  
    
public class java_53690_SocketServer_A03 {      
      public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(4001);          
            System.out.println("Waiting for client connection...");            
              Socket socket=server.accept();    //Accepts incoming requests                  
               PrintWriter out = 
                  new PrintWriter(socket.getOutputStream(),true);  
                 BufferedReader in =new BufferedReader (                          
                     new InputStreamReader(socket.getInputStream()));        
                    String userInput, serverResponse;       
                      do{  //To maintain the connection until client sends a message   
                         System.out.println("Enter something: ");  
                          userInput=in.readLine();      
                        if (userInput==null) break ;             
                           else {            system ("Echo from server : "+用户输入);             }  //Mimicking echo function to respond back with client input     
                    while(true){     try{Thread.sleep(1000)}catch(Exception $ex$ ){}   catch (Throwable $ex$) {  $ ex . printStackTrace() ;}}       finally {}          }}while （ true ）;    }finally {};     
            out.close(); socket.close(); server.close();     System.out.println("\n Closed all the sockets");   });        try{ Thread.sleep(10);}catch (Exception $ex$){  $ ex . printStackTrace() ;}} catch（Throwable $  ) {    $ 异常。打印堆栈跟踪；}}}
This is a very simple example and does not include things like error handling, data persistence or user management. Also it uses legacy code for simplicity's sake due to the limited use of libraries in Java standard edition (1.5 onwards). In production-grade applications you would want more robust security measures including encryption/decryption using SSL library etc., and also proper exception throwing when necessary, among other things which are not included here because they require many lines or complex logic for a simple server example to cover all cases properly in real application scenarios.