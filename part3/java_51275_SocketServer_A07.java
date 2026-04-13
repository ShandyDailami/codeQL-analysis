import java.io.*;  // Import necessary classes  
import java.net.*;   

public class java_51275_SocketServer_A07 {    
      private static final String PASSWORD = "securePassword";      
          
        public static void main(String[] args) throws IOException{        
            ServerSocket serverSocket  = new ServerSocket();          // Create the socket at port 5004.   
             System.out.println("Server started");     
             
                try {    
                    while (true){      
                        Socket client = serverSocket.accept();           // Accept a connection from outside world  
                         System.out.println("\nConnected with " +client.getRemoteSocketAddress());         
                          
                            DataInputStream inStream =  new DataInputStream(client.getInputStream());     
                                String userInput  = inStream .readUTF();      
                                        if (!checkPassword(userInput)) {             ConsoleWriter cw =new  consolewriter ();              // If the input password is incorrect, print error message to stdout   System. outprintln ("Wrong Password"); } else{                  ServerThread st= newServer Thread((client));         serverSocket .close();    
                         }} catch(Exception e){        ConsoleWriter cw =new  consolewriter ();              // If exception occurs at any point, print error message to stdout   System. outprintln ("Error Occurred"); }    finally {          if (!serverSocket.isClosed()) serverSocket .close();}}                 
     private static boolean checkPassword(String password){      return PASSWORD ==password;}  // Return true or false based on whether the inputted passsword matches our predefined one}  
       public class consoleWriter implements PrintStream {    System.setOut (newconsolewriter());        }// Use a new Console writer if necessary}};            while(true){                     String userInput=in .readUTF();  //Read from the input stream                   try{              serverSocket ..sendUtfString...