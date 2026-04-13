import java.io.*;
import java.net.*;
public class java_50853_SocketServer_A01 {  // Server Class name will depend on the context of use - e.g., 'SecureSocket' might fit better here!  
    public static void main(String args[]) throws Exception{    
        int port = 1234;      /* default */
         if (args.length == 0){  // Port checking is not included in this example, but should be done for real use cases as per A05_BrokenAccessControl  
             System.out.println("Please enter the server's port number:");   
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  // Reading from console to input a Port Number for real use cases as per A05_BrokenAccessControl  
             String userInputPortNumberString=reader.readLine();       /* default:1234 */     int portnumber = Integer.parseInt (userInputPortNumberString);    if(port != 1){  // Port Number Checking is not included in this example, but should be done for real use cases as per A05_BrokenAccessControl  
                 System.out.println("Using the input port number "+ Integer.toString (portnumber) +". ");     }      else {    Socket echoSocket = null;  // socket that will connect to client's localhost:6789 on default machine and use random assigned one as server listening connection
             System.out.println("Waiting for a port number...\n");            while ((portnumber =  Integer .parseInt (reader.readLine())) ==0 ){  // Wait until an actual Port Number is given by user, not zero   }    echoSocket = new Socket(InetAddress.getByName("127.0.0.1"), portnumber);
        System.out.println ("Connected to server at: " +port );           BufferedReader readerPassword=new BufferedReader (  // Security related code goes here - for example password validation    InputStreamReader isRead= new InputStreamReader(System.in)   ,1024);
        System.out.println ("Enter your Password\n");                     String userInputString =readerPassword .readLine();         char []passwordcharacters =  userInputString .toCharArray ( );     // Convert the password string to a character array          int length=    passLength;      for(int i= 0 ;i<passLength/2 +1  ){       if((length-i)==  497){