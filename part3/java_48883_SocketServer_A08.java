import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_48883_SocketServer_A08 {  //main function starts here   (e)^I_ThinkInRealLife!(f I think so, f you are a real life programmer!)
    private static final int PORT = 12345;       //define the port for server to listen on. Let's say it is 8096 in our case (a)^I_ThinkInRealLife!(f I think so, f you are a real life programmer!)
    private static SSLServerSocket sslServerSocket = null;   //declare the variable for HTTPServer Socket. Let's name it as secure socket server in our case (a)^I_ThinkInRealLife!(f I think so, f you are a real life programmer!)
    private static ExecutorService executor ;  // Declare an thread pool to handle multiple connections at the same time using java.util package's class ie.,ExecutorServices   (d)^I_ThinkInRealLife!(f I think so, f you are a real life programmer!)
    private static SSLContext sslcontext;  // Declare an context for our server to use when establishing secure socket connections using javax.net package's class ie.,SSLServerSocket and SSLEngine (c)^I_ThinkInRealLife!(f I think so, f you are a real life programmer!)
    private static SSLSocket clientsocket = null;  // Declare the variable for socket that accepts client requests. Let's name it as secure sockets in our case   (d)^I_ThinkInRealLife