import java.io.*;
import java.net.*;

public class java_12836_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // port number
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // waiting for client
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // read the request from the client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // simulate a security-sensitive operation
            if (request.contains("DROP TABLE")) {
                String response = "Security violation detected. DROPPING TABLE";
                dos.writeUTF(response);
                dos.flush();
            } else {
                String response = "Request processed";
                dos.writeUTF(response);
                dos.flush();
            }

            socket.close();
        }
    }
}