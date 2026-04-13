import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40195_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444); // Set a port
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept(); // Accept a new connection
            System.out.println("A new client has connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read data from the client
            String data = dataInputStream.readUTF();
            System.out.println("Received: " + data);

            // Send data to the client
            dataOutputStream.writeUTF("Hello client, data received");
            dataOutputStream.flush();

            socket.close();
        }
    }
}