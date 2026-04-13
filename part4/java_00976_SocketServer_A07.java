import java.io.*;
import java.net.*;
import java.util.*;

public class java_00976_SocketServer_A07 {

    private static final String SERVER_SOCKET = "Server Socket";
    private static final String CLIENT_SOCKET = "Client Socket";
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 4000;
    private static List<PrintWriter> clientOutputStreams;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        clientOutputStreams = Collections.synchronizedList(new ArrayList<>());

        while (true) {
            try {
                System.out.println("Waiting for client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clientOutputStreams.add(out);

                handleClient(clientSocket);
            } catch (IOException e) {
                System.out.println("Exception caught when trying to accept connection from client.");
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received message from client: " + message);

            // Simulate authentication failure
            if (message.equals("authFail")) {
                PrintWriter authFailedWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                authFailedWriter.println("Authentication failed!");
                authFailedWriter.flush();
                clientOutputStreams.remove(authFailedWriter);
                System.out.println("Authentication failed for client. Removing client connection...");
                clientSocket.close();
            } else {
                // Send message to all clients except the failed client
                for (PrintWriter out : clientOutputStreams) {
                    if (out != clientOutputStreams.get(clientOutputStreams.size() - 1)) { // skip the failed client
                        out.println(message);
                        out.flush();
                    }
                }
            }
        }
    }
}