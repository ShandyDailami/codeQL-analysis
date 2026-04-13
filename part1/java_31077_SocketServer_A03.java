import java.io.*;
import java.net.*;

public class java_31077_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            String response = processRequest(message);
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Add a security-sensitive operation such as injection attempt here
        // The purpose is to demonstrate the injection attack
        // This is a simple example of injection attack
        String injection = "Injection";
        return request + " " + injection;
    }
}