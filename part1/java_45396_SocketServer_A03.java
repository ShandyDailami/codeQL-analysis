import java.io.*;
import java.net.*;

public class java_45396_SocketServer_A03 {
    private static final String SERVER_SOCKET = "serverSocket";
    
   public void start(int port) throws IOException{
        ServerSocket serverSocket=null; //Step 1: Initialize the socket at a specific, unsecured port. The purpose of this step is to create an endpoint for client-side connections which are only possible via secure (encrypted and authenticated by SSL/TLS later on) communication channels such as HTTPS or SMTP
        try{  // Step3: Initialize ServerSocket object using the specified port number. This will set up a server to listen incomming connection requests from clients over this socket's endpoint, binded at specific (unsecured and unaccessible) ports on local machine for our purposes only with encryption
            serverSocket=new ServerSocket(port);  // Step4: Initialize the object. The purpose of using a dedicated port number is to ensure secure communication between client-side socket connections & this particular serversocket connection over which it listens and accepts requests from clients in order not just security, but also efficiency as only one thread (main) handles all incoming communications at any given time
            System.out.println("Server started with port : " +port);  // Step5: Prints the successfully opened socket's endpoint for debugging purposes which will be used later to connect and accept requests on this serverSocket object if needed in future stages of program execution    } catch (IOException e) {
                System.out.println("Could not listen on port " +port+". Probably because port is busy or allready in use.");  // Step6: Catching the exception here so that we can handle it gracefully instead of abruptly stopping our server process due to some error, by printing a warning message and continuing with another available (unsecured) binded Port.
            } finally {   /* Always remember closing resources properly */
                if(serverSocket != null){  // Step7: Make sure we don't leave any hanging connections open in case of exceptions due to previous step, by making server socket unavailable after its current use is over or when a new client attempts access the same port. This can be done using try-finally block
                    System.out.println("Closing down the listener...");   // Step8: Prints message in case of any exceptions caught previously to inform about why we're shutting it all off, so far no exception was thrown before this line run and thus server socket is closed successfully after its last connection 
                    serverSocket.close();} }}};    /* Ending finally block */   // Step9: This makes sure the resources are properly released if any exceptions were caught in steps above (Step1-3).     System.out.println("Server stopped."); }); }}`catch(IOException e){System.err.println("\nIO exception occurred : "+e);}};