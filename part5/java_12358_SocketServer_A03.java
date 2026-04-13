import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12358_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and a data input/output stream
        ServerSocket server = new ServerSocket(1234);
        Socket socket = server.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Create a message to send to the client
        String message = "Hello, client!";

        // Send the message
        out.writeUTF(message);

        // Wait for a response
        String response = in.readUTF();
        System.out.println("Server received: " + response);

        // Close the connection
        socket.close();
        server.close();
    }
}