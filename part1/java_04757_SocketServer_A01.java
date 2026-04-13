import java.io.*;
import java.net.*;

public class java_04757_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);

        System.out.println("Server is listening...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            if (clientMessage.equals("Kill the server")) {
                output.writeUTF("Server shutting down...");
                output.flush();
                socket.close();
            } else {
                String serverMessage = "Hello, client!";
                output.writeUTF(serverMessage);
                output.flush();
            }
        }
    }
}