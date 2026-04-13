import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15151_SocketServer_A08 {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // TODO: Handle client connection and communication
                // You can use a Thread or a new Thread to handle communication

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}