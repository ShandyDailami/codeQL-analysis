import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05894_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

            // Send a response to the client
            clientSocket.getOutputStream().write("Hello, Client!".getBytes());
            clientSocket.getOutputStream().close();
       
            clientSocket.close();
        }
    }
}