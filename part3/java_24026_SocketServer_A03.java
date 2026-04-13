import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_24026_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        ServerSocket serverSocket = null;
        try {
            // Set up SSL server socket
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(54321);
            sslServerSocket.setNeedClientAuth(true);

            // Accept a client connection
            Socket socket = sslServerSocket.accept();

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send response to client
            out.println("Hello, client!");

            // Close the connection
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close server sockets
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}