import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00207_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Here is where you can handle the socket data
                // For example, you can write a response to the client

                // For the sake of simplicity, we'll just close the connection here
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}