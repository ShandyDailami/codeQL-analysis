import java.net.*;
import java.io.*;

public class java_20085_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server on port " + PORT);

        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String messageFromClient;

            while (true) {
                try {
                    messageFromClient = in.readUTF();
                    System.out.println("Received message from client: " + messageFromClient);

                    if (messageFromClient.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected!");
                        break;
                    }

                    out.writeUTF("Server received: " + messageFromClient);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }

            clientSocket.close();
        }
    }
}