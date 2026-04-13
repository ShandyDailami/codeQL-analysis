import java.io.*;
import java.net.*;

public class java_37789_SocketServer_A03 {

    private static final String SERVER_STREAM_NAME = "Server Stream";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started at port " + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received client message: " + clientMessage);

            // Injecting clientMessage to bypass the check in the client code
            String serverMessage = processClientMessage(clientMessage);
            output.writeUTF(serverMessage);
            output.flush();

            socket.close();
       
        }
    }

    private static String processClientMessage(String clientMessage) {
        // Checking for SQL Injection
        if (clientMessage.contains(";")) {
            System.out.println("SQL injection attempt detected!");
            return "Server: Invalid SQL query";
        }

        // Checking for Command Injection
        if (clientMessage.contains("//")) {
            System.out.println("Command injection attempt detected!");
            return "Server: Invalid command";
        }

        return "Server: Processed message: " + clientMessage;
    }

}