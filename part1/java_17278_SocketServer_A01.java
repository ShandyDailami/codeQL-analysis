import java.io.*;
import java.net.*;

public class java_17278_SocketServer_A01 {
    private ServerSocket serverSocket;

    public java_17278_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                String response = "Hello, client, thanks for connecting to the server!";
                out.writeUTF(response);
                System.out.println("Sent response: " + response);

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            new VanillaServer(5000).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}