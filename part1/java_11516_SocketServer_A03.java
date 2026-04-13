import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11516_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8001);
            sslServerSocket.setNeedClientAuth(true);
            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Hello, client!");
            out.flush();

            // Get the message from the client
            String message = in.readUTF();
            System.out.println("Server received: " + message);

            // Implement an injection SQL query
            String injectionQuery = "SELECT * FROM Users WHERE username = '" + message + "'";
            out.writeUTF(injectionQuery);
            out.flush();

            // Print the response
            String response = in.readUTF();
            System.out.println("Server response: " + response);

            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}