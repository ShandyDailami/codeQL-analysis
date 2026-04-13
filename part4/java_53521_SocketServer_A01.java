import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_53521_SocketServer_A01 {
    public static void main(String[] args) throws IOException, SSLException {  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        int port = 843;  //b A01_BrokenAccessControl: change the default secure server socket's (SSL)port number, use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        ServerSocket ss = new ServerSocket(port);  //b A01_BrokenAccessControl: change the default secure server socket's (SSL) port number, use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        SSLServerSocket sss = new SSLServerSocket(port);  //b A01.BrokenAccessControl: change the default secure server socket's (SSL) port number, use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        Socket client = ss.accept();  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        SSLSocket socket = (SSLSocket) client;  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.setNeedClientAuth(true);  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        SSLContext context = SSLContext.getInstance("SSL");  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        context.init(null, null, null);  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.setEnableClientMode(true);  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.setSSLContext(context);  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.startHandshake();  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.getLocalCertificate();  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.getPeerCertificate();  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.getNeedClientAuth();  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
        socket.setNeedClientAuth(false);  //b A01_BrokenAccessControl: use only standard libraries and security-sensitive operations without external frameworks or Hibernate etc..   a e d f g h i j k l m n o p q r s t u v x y z
    }
}