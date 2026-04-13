import java.io.*;
import java.net.*;

public class java_16663_SocketServer_A08 {
    private static int serverPort = 12345;
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started on port: " + serverPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("Server error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            System.out.println("Server has stopped.");
        }
    }

    public static void handleClient(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String clientInput = reader.readLine();
            System.out.println("Received: " + clientInput);

            // Sending integrity check message
            String integrityCheck = "A08_IntegrityFailure";
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(integrityCheck);

            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}