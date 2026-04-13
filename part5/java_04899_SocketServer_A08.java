import java.net.*;
import java.io.*;

public class java_04899_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(5000); // Assuming port 5000 is free
            System.out.println("Server is listening on port 5000");

            while (true) {
                socket = serverSocket.accept(); // Accepting client connection
                System.out.println("Client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String request = input.readUTF();
                System.out.println("Request received: " + request);

                String response = "Hello, client!";
                output.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}