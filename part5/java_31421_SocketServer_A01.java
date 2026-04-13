import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31421_SocketServer_A01 {
    private ServerSocket serverSocket;
    private Socket socket;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            // Accept a client
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create output stream
            OutputStream outputStream = socket.getOutputStream();

            // Create input reader
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read from client
            String message = inputReader.readLine();
            System.out.println("Client says: " + message);

            // Send back a response
            outputStream.write("Hello, client! You said: " + message + "\n".getBytes());

            // Close connection
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start(9999);
    }
}