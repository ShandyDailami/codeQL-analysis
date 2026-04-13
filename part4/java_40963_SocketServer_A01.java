import java.net.*;
import java.io.*;

public class java_40963_SocketServer_A01 {
    private static final String DISCONNECT_MESSAGE = "DISCONNECT";
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(5000);
    }

    public static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established with " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String clientInput;

            while (!(clientInput = input.readUTF()).equals(DISCONNECT_MESSAGE)) {
                System.out.println("Received: " + clientInput);

                // Security-sensitive operation - not recommended for production code
                // This example only serves to demonstrate the concept.
                String response = "Server response: " + clientInput;
                output.writeUTF(response);
                output.flush();
           
            }

            System.out.println("Connection closed.");
            clientSocket.close();
        }
    }
}