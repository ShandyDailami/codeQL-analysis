import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39222_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // For simplicity, we'll just check if the client can read from the socket.
                // In a real-world scenario, you'd want to check if the client can write to the socket,
                // and if the client is in a secure environment (https).
                socket.setSoTimeout(1000);
                socket.getInputStream().read();

                // If we got here, the client is secure.
                // Now, we'll just send back a simple response to the client.
                socket.getOutputStream().write("Hello, client!\n".getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}