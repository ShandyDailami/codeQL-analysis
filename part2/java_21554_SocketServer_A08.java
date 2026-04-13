import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21554_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                // Step 2: Accept incoming connection
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Step 3: Handle the communication with the client
                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}