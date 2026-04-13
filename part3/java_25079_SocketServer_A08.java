import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_25079_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;
        Socket connection = null;

        try {
            // Create a new SSLServerSocket
            SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept a new connection
            socket = (ServerSocket) sslServerSocket.accept();

            // Create a new SSLSocket
            sslSocket = (SSLServerSocket) socket.accept();

            // Get the input stream from the SSLSocket
            InputStream input = sslSocket.getInputStream();

            // Create a new InputStreamReader
            InputStreamReader reader = new InputStreamReader(input);

            // Create a new BufferedReader
            BufferedReader bufferedReader = new BufferedReader(reader);

            // Read a line from the BufferedReader
            String line = bufferedReader.readLine();

            System.out.println("Client says: " + line);

            // Close the connection
            sslSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}