import java.io.*;
import java.net.*;

public class java_16547_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        Socket socket = server.accept();
        System.out.println("Client connected at: " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Reading the request from the client
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        // Sending a response back to the client
        String response = "Hello, client!";
        out.writeUTF(response);
        out.flush();

        socket.close();
        server.close();
    }
}