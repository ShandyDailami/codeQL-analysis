import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36809_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        // Create the SSLContext with the key and certificate
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext = SSLContext.getInstance("TLSv12");
        sslContext.init(null, new TrustManager[] { new TrustManagerSSL() }, null);

        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8080);

        // Listen for incoming client connections
        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Print the client's request
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            out.writeUTF("Server: Hello, client!");
            out.close();

            // Close the client socket and server socket
            clientSocket.close();
            serverSocket.close();
       
        }
    }
}