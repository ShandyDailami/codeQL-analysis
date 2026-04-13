import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_05082_SocketServer_A08 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        // create a SSLServerSocketFactory using the custom SSLContext
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // create a new SSLServerSocket with the SSLServerSocketFactory and port 8080
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // set the SSLServerSocket to accept client connections
        sslServerSocket.setNeedClientAuth(true);

        // create a ServerSocket and bind it to port 8080
        ServerSocket serverSocket = new ServerSocket(8080);

        // accept client connections
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // pass the socket to SSLServerSocket for further communication
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(socket, 1024, true, true);
            sslServerSocket.setNeedClientAuth(true);

            // start reading data from the socket
            while (true) {
                // read a line of data from the socket
                String data = sslServerSocket.readLine();
                System.out.println("Received: " + data);

                // send a response back to the client
                sslServerSocket.write(("Response: " + data).getBytes());
                sslServerSocket.flush();
            }
        }
    }
}