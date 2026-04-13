import java.io.*;
import java.net.*;
import java.util.*;

public class java_27090_SocketServer_A08 {
    private static int port = 6000;
    private static ServerSocket serverSocket;
    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            // Create Server Socket
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Accept Client Socket
            clientSocket = serverSocket.accept();
            System.out.println("Client is connected");

            // Create Input Stream and Output Stream
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Reading from Client
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            // Sending back a message
            out.println("Hello Client, you connected successfully!");

            // Close the streams and Socket
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}