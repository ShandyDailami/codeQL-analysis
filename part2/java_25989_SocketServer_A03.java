import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25989_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // Create a server socket on port 8080
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a client socket
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // Read a message from the client
            System.out.println("Received: " + message);

            if (message.length() > 100) {
                message = "Injection attempt detected!";
            }

            out.writeUTF("Hello, " + message); // Send a response back to the client
            socket.close(); // Close the socket
        }
    }
}