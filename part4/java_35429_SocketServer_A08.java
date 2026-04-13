import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35429_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("Server is listening on port 9999...");

        while (true) {
            Socket client = server.accept();
            System.out.println("A client has connected!");

            // Secure the data stream by wrapping the input and output streams with BufferedInputStream/OutputStream
            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            // Read the client message
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, Client!";
            output.writeUTF(response);
            output.flush();

            client.close();
        }
    }
}