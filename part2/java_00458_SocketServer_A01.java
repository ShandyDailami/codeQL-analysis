import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00458_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // listening on port 8080
            System.out.println("Waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept(); // accept a client connection
                System.out.println("Client connected!");

                // write to the client
                socket.getOutputStream().write(("Hello, Client\n").getBytes());
                socket.getOutputStream().flush();

                socket.close(); // close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}