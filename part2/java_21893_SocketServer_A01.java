import java.io.*;
import java.net.*;

public class java_21893_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server is running on port " + PORT);

            while (true) {

                try (Socket clientSocket = serverSocket.accept()) {

                    System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                    DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                    String message = input.readUTF();
                    System.out.println("Received: " + message);

                    String response = "Hello, client!";
                    output.writeUTF(response);
                    System.out.println("Sent: " + response);

                    clientSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}