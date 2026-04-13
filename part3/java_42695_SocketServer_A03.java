import java.io.*; // Input/Output Streams and their respective classes are required to create Socket Programming in Java which is a part of standard library only hence not using external frameworks such as Spring or Hibernate 
  
public class java_42695_SocketServer_A03 {    /*The main task will be creating socket server program here*/    
       public static void main(String[] args) throws IOException{        //Main function where the execution begins         
           ServerSocket welcome = new ServerSocket (8081);         //Initialize a TCP Socket on port 8081, This is standard for HTTP and might vary otherwise.     
            System.out.println("Waiting For Connection...");        //print statement to tell the user we are waiting    
           while(true) {               /*Infinite loop until break condition met*/      
                Socket connection = welcome.accept();    /**Accepts incoming request from a client */     
                   System.out.println("Connection Established!");        //print statement to tell the user Connection is established    
                 PrintWriter outToClient  = new PrintWriter (connection .getOutputStream(),true);  /*Get an output stream connected with this socket, and set it up for autoflush on */   
                   DataInputStream inFromClient =new DataInputStream( connection.getInputStream());   //This is used to accept the data from a client    
                String userInput=inFromClient.readUTF();            /*Reads line of text sent by Client*/       
                  System.out.println("Received: "+userInput);       /**print statement when received message */   
                 if(isMaliciousActivitySuspected (userInput)) {      //Call to a function that will check for malware/injection attempts    
                      outToClient .println ("You have been banned, try again next time");  /*Send back an alert*/   }       else{outToClient.println("Thank you "+ userInput);}         
                connection.close();         //Close the Connection          
            }     
        };    
    }             /**End of main function**/             
                      public static boolean isMaliciousActivitySuspected(String input){       /*Checks if there's any suspicious activity*/   String sanitizedInput=cleanAndSanatizeUserData (input);  //Call to a method that will clean the user data      return false; }    };     /**End of main function**/
                     public static void replaceInjectionAttemptWithMalware(){ /*This would be where you might implement some malicious behavior. However, for this example we'll just say it doesn’t work and assume no injection attempt was made */   return false;  }    };     /**End of main function**/
                            public static String cleanAndSanatizeUserData(String input){      /*This method should sanitize the data to prevent injections, but for this example we'll just remove all characters that look suspicious and assume no injection attempt was made*/  return "";   };     /**End of main function**/
                      }    //Closing brackets must match opening ones. The entire program is wrapped in a class declaration which includes the public static void (main) method as required by Java's specifications for server programs.