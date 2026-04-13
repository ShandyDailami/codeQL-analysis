import java.io.*;
import java.net.*;

public class java_02838_SocketServer_A03 {
    private static int DEFAULT_PORT = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            OutputStream out = new PrintWriter(clientSocket.getOutputStream(), true);
            InputStream in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Handling client: " + clientSocket.getInetAddress().getHostAddress());
            String clientMessage, serverMessage;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while ((clientMessage = reader.readLine()) != null) {
                serverMessage = "Server: " + clientMessage;
                out.println(serverMessage);
                System.out.println("Client: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}