import java.io.IOException;
import java.net.SSLServerSocket;
import java.net.Socket;

public class java_17322_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // create SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) SSLServerSocket.createServerSocket(8001);
        sslServerSocket.setNeedClientAuth(true);
        
        System.out.println("Server is waiting for client connection...");

        // accept client connection
        Socket socket = sslServerSocket.accept();
        System.out.println("Client connected!");

        // write data to client
        socket.getOutputStream().write("Hello Client!".getBytes());

        // close connection
        socket.close();
        sslServerSocket.close();
    }
}