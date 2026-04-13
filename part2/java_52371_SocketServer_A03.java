import java.net.*;   // for ServerSocket and DatagramSocket classes   
public class java_52371_SocketServer_A03 {    
        public static void main(String args[]) throws Exception{      
            int port = 6001;     
                if (args.length != 1){          System.out.println("Usage: java EchoServer <port>");   return;}  // check command line argument   
                  try {                         
                      port = Integer.parseInt( args[0]);     }       catch (NumberFormatException e)          
                         {        
                            System.out.println("Invalid Port Number.");      return;                   };       
            ServerSocket sock= new ServerSocket(port);    // server socket on given port  
             while(true){                    Socket incoming =sock .accept();     DataInputStream inStream = 
                 new  DataInputStream (incoming.getInputStream());                      System.out.println("Waiting for Message..");      String message=null;            try{    //read a string from the client  
                     message  = inStream.readUTF();           }       catch(IOException e){              return;}                    if(message == null) {sock.close();return;}                      System.out.println("Echoing back message to the client: " +message);          try{      // write a string to the client  
                     PrintStream outStream  = new  PrintStream (incoming.getOutputStream());     outStream .print(message );           }       catch(IOException e){         return;}                        sock.close();}                 };    });//end of main method}};                  Exception here is just catching for now, in reality we will handle this exception with appropriate logging and recovery mechanisms!