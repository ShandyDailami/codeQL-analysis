import java.io.*;
import java.net.*;

public class java_23040_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            // Authentication
            if (request.contains("A07_AuthFailure")) {
                output.writeUTF("AuthFailure");
                output.flush();
            } else {
                output.writeUTF("Success");
                output.flush();
            }

            socket.close();
        }
    }
}