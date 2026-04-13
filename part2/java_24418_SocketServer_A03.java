import java.io.*;
import java.net.*;

public class java_24418_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Creating new thread for each client
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                    String clientMessage;
                    while ((clientMessage = reader.readLine()) != null) {
                        System.out.println("Received: " + clientMessage);
                        // In a real-world application, you would want to sanitize user inputs and prevent injection attacks
                        // This is a simplistic example and does not handle the specific security concern A03_Injection
                        String serverMessage = "Server says: " + clientMessage;
                        writer.writeBytes(serverMessage + '\n');
                    }
                    writer.writeBytes("Connection closed by client\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}