) 
import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_44902_SocketServer_A01 {
    private static final String HOST = "localhost"; // change as needed, can be an IP or hostname of a server you want to connect too e.g., '127.0.0.1' 
    private static final int PORT = 8956;// any available unoccupied port number on your machine that is greater than the default (non-SSL: below, or above) and non-reserved by system - usually between about 49152 to 60975
    private static final int BACKLOG = 3; // defines how many connections this socket can queue before rejecting new ones. A positive integer value indicates the maximum number of simultaneous connection requests that will be accepted but won't start processing until there is at least one listener or thread waiting to accept on a socket in the listening sockets array
    private static final String ALGORITHM = "AES"; // symmetric encryption algorithm – AES, DES etc. This example uses Symantec Java Cryptography Archive (JCA) Standard Algorithms from J2ME and Android versions only due to limitations on external frameworks usage in this context
    private static final Key KEY_FOR_ENCRYPTION = generateKey(); // symmetric encryption key, change it as needed – usually generated with javax.crypto package for AES algorithm: example - new SecretKey()  
        ... rest of your class code goes here .....    
}// end SecureSocketServer