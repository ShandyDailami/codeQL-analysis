import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_05852_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a SSLServerSocket
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(8443);
            sslServerSocket.setNeedClientAuthentication(true);
            sslServerSocket.setEnabledProtocols(new String[] {"TLSv1.2"});

            // Accept a client socket
            serverSocket = (ServerSocket) sslServerSocket.accept();

            // Create a new socket and get an input and output stream
            Socket clientSocket = serverSocket.accept();
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Create a buffered reader and write a message to the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.println("Thank you for connecting to the server");
            }
            clientSocket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}