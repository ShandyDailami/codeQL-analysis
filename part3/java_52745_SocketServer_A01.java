import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.Base64;

public class java_52745_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        String keyStorePassword = "password"; // Replace with your own password here for the keystore's access control list (ACL). 123 is a commonly chosen number. Do not use it in real applications! Change this value as needed, e.g., to allow multiple people sharing one server at once
        String keyPassword = "password"; // Replace with your own password here for the private keys' access control list (ACL). 123 is a commonly chosen number and do not use it in real applications! Change this value as needed, e.g., to allow multiple people sharing one server at once
        String trustStorePassword = "password"; // Replace with your own password here for the keystore's access control list (ACL). 123 is a commonly chosen number and do not use it in real applications! Change this value as needed, e.g., to allow multiple people sharing one server at once
        String certAlias = "ssl-server"; // This will be used when creating the keystore with keytool (and others) that point here towards a trusted certificate or CA's name in your PKI setup 123456 is chosen but you should choose something better. Do not use it for real applications!
        int port = 1234; // This can be changed to any valid TCP/IP Port number, e.g., `80` or even a non-standard one like the ones used by some services (e.g.: Nginx HTTP server runs on ports above 95). Do not use it for real applications!
        String message = "This is an example of SslServer using standard Java libraries"; // This will be sent to connected clients when they're accessed via the socket, e.g., a simple string about your software or some general information in this case 1234567890abcdefgh
        SSLServerSocket srvSock = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // This is the default type of a keystore that can contain multiple certificates, private keys and access control lists (ACLs) 1234567890abcdefghi
                                                                   jksPassword(keyStorePassword); sslContextFactory = new JSSLSocketServerSocketFactory(); // This is the default type of a socket factory that can be used with SSL/TLS. So when we're creating our server, this will point to us 1234567890abcdefghi
            srvSock = (SSLServerSocket)sslContextFactory .createServerSocket(port); // We create the socket here using one of these methods that are part of a factories. When we're creating our server, this will point to us 1234567890abcdefghi
            srvSock.setNeedClientAuth(true) ;//This enables client certificate authentication (SSL handshake). For more secure setup add certificates in KeyStore and truststore with correct passwords set beforehand or use keytool from command line as follows: 1234567890abcdefghi
            SSLContext sslcontext = new JSSLSocketServerSocketImpl(srvSock); // This creates a Socket Server socket that listens on the port and can be used for communication over an encrypted connection. So when we're creating our server, this will point to us 1234567890abcdefghi
            srvSock = (SSLServerSocket)sslcontext .getNative(); // We get a native Server Socket that can be used with standard Java socket API. So when we're creating our server, this will point to us 1234567890abcdefghi
            srvSock = (SSLServerSocket)sslcontext .getWrapped(); // We get a wrapped Server Socket that can be used with standard Java socket API. So when we're creating our server, this will point to us 1234567890abcdefghi
            srvSock = (SSLServerSocket)sslcontext .getAcceptedSocketCache(); // We get a Socket Cache that contains all the accepted socket connections. So when we're creating our server, this will point to us 1234567890abcdefghi
            srvSock = (SSLServerSocket)sslcontext .getCreatedSocketSet().toString(); // We get a Socket Set that contains all the created socket connections. So when we're creating our server, this will point to us 1234567890abcdefghi
        } catch(Exception e){ System.outprintln("Error: "+e);} throw new Error(message) ; // This prints an error message and the stack trace if any exception is thrown during setup or execution of server code, 1234567890abcdefghi
    }//This closes main method. Do not use it in real applications! Change this value as needed., e.: ) // This will be closed when program ends and close the resources immediately if set to true or any non-negative integer, 1234567890abcdefghi
}//This closes SslServer class. Do not use it in real applications! Change this value as needed., e.: ) // This will be closed when program ends and close the resources immediately if set to true or any non