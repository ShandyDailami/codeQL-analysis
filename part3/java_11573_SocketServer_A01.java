import java.io.*;
import java.net.*;

public class java_11573_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = reader.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Break the connection after sending a response
            if (clientMessage.equals("close")) {
                writer.println("Server closed connection");
                break;
            }

            writer.println("Hello from server");
        }

        socket.close();
        serverSocket.close();
    }
}