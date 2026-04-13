import java.io.*;
import java.net.*;
import javax.security.auth.message.callback.Callback;
import java.util.*;  // for List, ArrayList etc...    (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
import java.security.*; // for KeyPairGenerator, SecureRandom (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
import javax.net.ssl.*; // for SSLServerSocket, ServerSocket (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
import javax.crypto.*; // for Cipher (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
import javax.crypto.spec.*; // for SecretKeySpec (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
class java_51180_SocketServer_A07 {  // class definition starts here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
    public static void main(String[] args){  // method definition starts here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
        try {  // exception handling starts here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            KeyPairGenerator kpg = 
                KeyPairGenerator.getInstance("SunRSASignature", "BC");  // using SunJCE provider (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            SecureRandom sr = new SecureRandom();  // secure random number generator (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            kpg.initialize(sr, 256); // key pair size (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            KeyPair kp = kpg.generateKeyPair();  // generate key pair (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            Certificate cert = kp.getCertificate(); // get certificate (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            FileOutputStream fos = new FileOutputStream("server.crt"); // file output stream (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            fos.write(cert);  // write certificate to file (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            fos.close(); // close file output stream (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            SSLServerSocket sslserver = new SSLServerSocket(8082, null); // create server socket (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            sslserver.setNeedClientAuth(true); // set need client auth (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//   JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            SSLServerSocket sslserversocket = (SSLServerSocket)sslserver; // cast server socket to its base class so that we can accept client connections with it.  This is a way of casting in Java, which you may use instead if needed   ******A16-BEGIN**********//
            Socket clientsocket =  sslserversocket .accept();    (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true);   // print writer starts here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            String reply;   // declare string variable (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            out.println("Hello Client, you are connected to the SSL server");   // print writer here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            reply = in.readLine();   // read line from client (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            out.println("Server received your message : "+ reply);   // print writer here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            clientsocket.close(); // close client socket (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            sslserversocket.close(); // close server socket (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            System.out.println("Closing down the connections"); // print statement (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
        } catch(Exception e){ // exception handling ends here (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
            e.printStackTrace(); // print exception details (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
        } // end of catch block (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
    } // end of main method (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES
} // end of class definition (a07) AUTH FAILURE BLOCK ENDS HERE     a95_AuthFailure      ******A16-BEGIN**********//  JAVA SECURITY IMPORTANT: ALLOW ONLY STANDARD LIBRARIES