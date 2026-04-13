import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26322_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 9876; // the port that we want to listen to

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                OutputStream outputStream = socket.getOutputStream();
                String response = "Hello, client!";
                outputStream.write(response.getBytes());
                outputStream.close();
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}