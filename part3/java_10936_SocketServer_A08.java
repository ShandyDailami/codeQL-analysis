import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10936_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
            clientSocket.getOutputStream().write("Hello, client!".getBytes());
            clientSocket.close();
        }
    }
}