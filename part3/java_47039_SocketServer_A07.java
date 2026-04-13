import java.io.*; // for Input/Output Streams  
import java.net.*; //for ServerSocket & Socket classes     
public class java_47039_SocketServer_A07 {      
    private static final int PORT = 80;          
     public static void main(String[] args) throws IOException{           
         try (ServerSocket server = new ServerSocket(PORT);            
              Socket clientSocket  =server.accept(); )  //waiting for a connection  
          {     
               System.out.println("Client connected");   
                BufferedReader in =new BufferedReader((InputStreamReader(clientSocket.getInputStream())));      
                  PrintWriter out= new PrintWriter (clientSocket.getOutputStream(),true);             //for sending back information to the client  .  
               String message, response;           
        while ((message  =in.readLine()) != null) {         
                   if ("exit".equals(message))           break ;              System.out.println("Received: "+message );      
                       //simulating a failure in authentication... 
                        int rand = (int)(Math.random() *10);     randomFails=rand;   for (; i < failsBeforeSuccess;) {      if(i>=failsToFail){ System . out \t\n " Connection Failed" ; break;} else{ //simulate a failed login   
                        Random rand = new Random();  int n = 10 + rand.nextInt(70);   failAttempts++;     for (int x = 0;x < n ; x ++) { System . out \t\n " Attempt"+failAttempts;} }   
                          //simulate successful login if we've made a certain number of fails.  randomSucceeded = new Random().nextInt(15);      for (int j = 0;j <randomSucceeded ; ++) {System . out \t\n " Login Successful"};   
                          response=("Server: Hello Client, You're authenticated successfully!").replace("\t", " ");   //constructing the server’s reply  } catch (IOException e){     System.out.println(e);}      break;        }}                  in .close(); out . close() ; clientSocket .close () ){
                     try { if (server != null && server.isClosed()) return;}catch (Exception ex) {}              ServerSocket server =null: } catch ….. e){ System .outprintln(e);}   });         //the end of the program             }}                   |]})    */