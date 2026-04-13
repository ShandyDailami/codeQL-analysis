import java.io.*;
import java.net.*;

public class java_18420_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

        String message;
        while ((message = reader.readLine()) != null) {
            System.out.println("Received message: " + message);
            writer.writeBytes("Hello client, you sent: " + message + "\n");
        }

        socket.close();
        serverSocket.close();
    }
}