import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21596_SocketServer_A03 {

    private static final int PORT = 1234; // chosen port

    public static void main(String[] args) throws IOException {
        // step 1: create server socket
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // step 2: wait for client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // step 3: handle client's request
            // This is a very basic example, a real server would need to handle multiple clients and handle different types of requests
            String request = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
            System.out.println("Received request: " + request);

            // step 4: send response back to client
            String response = "Server response";
            socket.getOutputStream().write(response.getBytes());

            // step 5: close connection
            socket.close();
        }
    }
}