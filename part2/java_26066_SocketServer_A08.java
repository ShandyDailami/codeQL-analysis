import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_26066_SocketServer_A08 {
  public static void main(String[] args) throws Exception {
    SSLServerSocket serverSocket = null;
    SSLSocket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;

    try {
      SSLServerSocketFactory sslServerSocketFactory =
        (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
      serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

      // start the server
      while (true) {
        socket = serverSocket.accept();
        socket.setNeedClientAuthentication(true);
        // wrap socket in a buffered reader and writer
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // read request
        String request = in.readLine();
        System.out.println("Received: " + request);

        // handle request
        if ("QUIT".equals(request)) {
          out.println("Goodbye!");
        } else {
          out.println("Hello, Client!");
        }

        out.flush();
      }
    } finally {
      socket.close();
      serverSocket.close();
    }
  }
}