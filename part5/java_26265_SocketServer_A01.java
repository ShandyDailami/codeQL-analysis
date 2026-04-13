import java.io.*;
import java.net.*;

public class java_26265_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String request = input.readUTF();
                System.out.println("Received: " + request);

                String response = "Hello, client!";
                output.writeUTF(response);
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}