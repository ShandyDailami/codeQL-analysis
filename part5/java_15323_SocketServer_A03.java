import java.net.*;
import java.io.*;

public class java_15323_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_15323_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Starting server on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = processMessage(message);
                out.writeUTF(response);
                out.flush();
                System.out.println("Sent: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String processMessage(String message) {
        // This is a simple function that just replies with the same message
        return message;
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(1234).startServer();
    }
}