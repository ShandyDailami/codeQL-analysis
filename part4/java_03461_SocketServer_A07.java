import java.io.*;
import java.net.*;

public class java_03461_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a socket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port: " + 8080);

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create input and output streams
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Read a line from the client
                String line = dataInputStream.readUTF();
                System.out.println("Received: " + line);

                // Send a response back to the client
                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}