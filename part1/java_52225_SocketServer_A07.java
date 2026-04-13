import java.io.*;
import java.net.*;
  
public class java_52225_SocketServer_A07 {   
       public static void main(String args[]) throws Exception 
        {     
            ServerSocket server = new ServerSocket(1234);     //Create a socket on port number one less than the assigned port value (i.e., below 1024), and wait for client to connect with accept() method .   
         System.out.println("Waiting For Client On Port: "+server.getLocalPort());     
           Socket s = server.accept();   //Accept the incoming connection      
            DataInputStream dis= new DataInputStream(s.getInputStream());  // Get input stream and wrap it in a datainputstream   
             BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));     
               System.out.println("Connected To Client : "+ s.getInetAddress().getHostAddress() );  
              String clientmessage= dis.readUTF();  //Read a string from the socket   
            while (true) {    
                if(clientmessage .equalsIgnoreCase ("Hello")){     
                    System.out.println("Client Says: Hello, How can I help you today?");  
                     String response = br.readLine();  //Read a string from the standard input   
                 } else {    
                      if (!(clientmessage .equalsIgnoreCase ("Exit")))     
                        System.out.println("Invalid Password");       return;         
                  s.close();   server.close(); break;}               default:break ;  //Default case, nothing happens            
            }}              } catch (IOException e){    print(e);}                   setdefaultcasecatchExceptionasidefinallyblockexceptionblocksafetherexceptionisinsidesomewhenanystringreadintostreaminreferencelockingstreamexceptionsarenotallowed1234567890}}
Here, I have used a catch-try block to manage any exceptions that may occur during execution of the code. In this case, if there is an error with reading from or writing to stream then it will be caught and handled within try/catch blocks allowing programmers more flexibility in handling such exceptional scenarios while also keeping their control at runtime due using exception handlers declared after a block (try) .