import java.io.*;
import java.net.*;
import java.util.*;

public class java_37866_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = "Hello, Client";
                output.writeUTF(message);

                String response = input.readUTF();
                System.out.println("Server says: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}