import java.io.*;
import java.net.*;

public class java_33655_SocketServer_A01 {

    private static final int PORT = 8080;
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static BufferedReader inFromClient;
    private static DataOutputStream outToClient;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outToClient = new DataOutputStream(socket.getOutputStream());

                String message = inFromClient.readLine();
                System.out.println("Received: " + message);

                String response = processRequest(message);
                outToClient.writeBytes(response + "\n");
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inFromClient != null) inFromClient.close();
                if (outToClient != null) outToClient.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String processRequest(String request) {
        // Implement access control mechanism here
        // For example, only allow connections from localhost
        if ("localhost".equals(request)) {
            return "Access granted";
        } else {
            return "Access denied";
        }
    }
}