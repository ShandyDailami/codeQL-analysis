import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sun.security.pkcs11.SecmodModuleFactoryImplPKCS11InternalNameProvider;

public class java_47286_SocketServer_A08 {  //Main Class for Socket Server Programming using SSL/TLS encryption and integrity check failure (A08_IntegrityFailure) in Java  
    private static final String CLIENT_IDENTIFIER = "SSLClient";
     public static void main(String[] args){        new SecureSocketServer().start();}  //Start Method for Socket Server Programming using SSL/TLS encryption and integrity check failure (A08_IntegrityFailure) in Java  
    private final int port = 1234;           byte[] b = {(byte)'c'};     FileOutputStream fos  = null ;       try{  //Main Method for Socket Server Programming using SSL/TLS encryption and integrity check failure (A08