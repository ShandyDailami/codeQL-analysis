import java.io.*;
import java.net.*;
import org.apache.commons.codec.digest.DigestUtils;  // Apache Commons Codec library for Hash functions, used here to get SHA-2 hash of the message/data sent from client

public class java_52566_SocketServer_A08 {  
    private static final String HASH_ALGORITHM = "MD5";     // MD5 algorithm is being utilized since we are using a SIGNATURE for integrity checking. 
                                                           // However, SHA-2 can also be used if required to provide stronger security against attacks (like collisions)  
    public static void main(String[] args){
        try {                         
            ServerSocket server = new ServerSocket(54321);         
             while(true){ 
                Socket socketConnection = server.accept();          
                 BufferedReader in =new BufferedReader (socketConnection.getInputStreamReader());  
                  PrintWriter out= new PrintWriter (socketConnection.getOutputStream(), true);    // ensure that the output stream is ready to send data back over TCP/IP    
                   String clientMessage; 
                    while ((clientMessage = in .readLine()) != null){      
                         if(isSignatureValidForIntegrityFailurePacket (socketConnection, HASH_ALGORITHM , clientMessage)){    // check the signature for validity. If it is valid then send back to the sender with response message "Success"  else drop packet     
                             out .println("SUCCESS");     }  
                         else{                              
                              System.out.println ("INVALID REQUEST FROM CLIENT ");                           
                         }}          
                 socketConnection.close();          // Close client connection here, not in while loop as it may cause infinite waiting for more clients  */}}}                      
        catch (IOException e) {e.printStackTrace();}   }    private static boolean isSignatureValidForIntegrityFailurePacket(Socket sock , String hashAlgorithm ,String message ){     // check the integrity of a packet using SHA-2 algorithm, this can be modified to use other algorithms as per requirement 
                try {byte[] bytes=message.getBytes();      ByteArrayInputStream bis = new ByteArrayInputStream (bytes);   MessageDigest md  =MessageDigest .getInstance(hashAlgorithm );    DigestUtils.update(md ,bis,0LONG);     return digestMatchesSignature ((INTEGER)sock,(byte[])(Object )new Object[128] ,"SUCCESS".getBytes(),bytes)} catch (Exception e){return false;}  
            } private static boolean isDigestMatchingSign(Socket s ,String hashAlgorithm, String messageToCheckSignatureAgainst, byte [] signatureFromClient) {     // check the integrity of a packet using SHA-2 algorithm with precomputed digest and client's sign. can be modified to use other algorithms as per requirement 
                try{return (DigestUtils .isEqual(signatureFromClient ,md.digest() ));} catch (Exception e){ return false; }   // Compare the digested message from server with sent signature, if they match then true else false    }}      This code should be compiled and run in a Java IDE that supports running java files or an online compiler