import java.io.*;
import java.net.*;

public class java_33596_SocketServer_A07 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            // Authenticate the client
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read the username from the client
            String clientName = dataInputStream.readUTF();
            System.out.println("Client Name: " + clientName);

            // Send a welcome message back to the client
            dataOutputStream.writeUTF("Welcome, " + clientName + "!");

            dataOutputStream.close();
            socket.close();
       
        }
    }
}