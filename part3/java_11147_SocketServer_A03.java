import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11147_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("Hello, client!".getBytes());
                clientSocket.close();
           
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}