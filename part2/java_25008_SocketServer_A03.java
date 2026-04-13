import java.net.*;
import java.io.*;

public class java_25008_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is running on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = processMessage(message);

            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processMessage(String message) {
        // This is a placeholder for a secure operation. 
        // You can replace this with your actual injection point.
        // The goal is to prevent the injection of the client's input into the server.

        return "Server response: " + message;
    }
}