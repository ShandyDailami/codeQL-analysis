import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_41474_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Create a server socket on port 8080
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // Accept a connection
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer); // Read data from the client
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                socket.close();
            } else {
                // Handle the received data here
                System.out.println("Received: " + new String(buffer, 0, bytesRead));

                // Send a response back to the client
                output.write("Hello client, you connected to the server!".getBytes());
                output.flush();
            }
        }
    }
}