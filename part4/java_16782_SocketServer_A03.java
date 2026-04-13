import java.io.*;
import java.net.*;

public class java_16782_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Listen for connections
        System.out.println("Server is listening on port 8080...");
        Socket socket = serverSocket.accept();

        // Create input and output streams
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Read the client's message
        String clientMessage = dis.readUTF();
        System.out.println("Client says: " + clientMessage);

        // Echo the client's message back to them
        dos.writeUTF("Server says: " + clientMessage);
        dos.flush();

        // Close the connection
        socket.close();
    }
}