import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22194_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket and accept incoming connections
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            // Accept a connection
            Socket client = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams for the client
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Read a message from the client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Server says: " + response);

            // Close the connections
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}