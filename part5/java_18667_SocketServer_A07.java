import java.io.*;
import java.net.*;

public class java_18667_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Perform authentication here
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage = reader.readLine();
            System.out.println("Client message: " + clientMessage);

            // Simulate an authentication failure
            if (!clientMessage.equals("auth_request")) {
                writer.writeBytes("auth_failure\n");
                writer.flush();
                System.out.println("Auth failure, closing connection...");
                socket.close();
            } else {
                writer.writeBytes("auth_success\n");
                writer.flush();
            }
        }
    }
}