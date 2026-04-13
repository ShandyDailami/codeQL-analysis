import java.io.*;
import java.net.*;

public class java_11773_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = processRequest(message);
            output.writeUTF(response);
            output.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // This is a placeholder for the actual security-sensitive operation.
        // For the sake of simplicity, let's just return the same request.
        return request;
    }
}