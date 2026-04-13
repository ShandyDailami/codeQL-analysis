import java.net.*; // Import URL and socket classes, etc... here we use http:// parts of it due for simplicity  
public class java_52529_SessionManager_A07 {    
    public static void main(String[] args) throws Exception{           
           try (Socket sock = new Socket("127.0.0.1", 80)) // Create a socket on port '80' and connect to localhost            
                {                       
                    String remoteHost;      
                     System.out.println(sock);      }     )   catch (Exception e)    {}         finally{ if (! sock .isClosed()){ try  {            // write request...          new BufferedReader(new InputStreamReader                          ((ConnectDataListener))).connect("www");
                  }} else throw it;}}' into the code. Here 'try-catch'-finally block is being used in order to ensure that exceptions occur, no matter how they occurred and finally statement guarantees any cleanup after try or catch blocks if necessary (in this case closing socket connection)  . Also note we are not using external libraries for authentication related operations as per the instructions.