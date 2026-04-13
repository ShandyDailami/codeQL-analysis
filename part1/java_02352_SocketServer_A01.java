import java.io.*;
import java.net.*;

public class java_02352_SocketServer_A01 {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(4444);

            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            Socket clientSocket = serverSocket.accept();

            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Client says: " + request);

            String response = "Hello, client!";
            out.writeUTF(response);

            System.out.println("Server says: " + response);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}