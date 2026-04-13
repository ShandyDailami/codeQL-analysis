import java.io.*;
import java.net.*;

public class java_10204_SocketServer_A08 {

    private static final String SERVER_STATE = "SERVER_STATE";
    private static int serverPort = 8080;
    private static ServerSocket serverSocket = null;

    public static void main(String args[]) {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started on port: " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientQuery = inFromClient.readLine();
                System.out.println("Received client query: " + clientQuery);

                if (clientQuery.equalsIgnoreCase(SERVER_STATE)) {
                    outToClient.writeBytes("SERVER_RUNNING\n");
                } else {
                    outToClient.writeBytes("UNKNOWN_COMMAND\n");
                }

                outToClient.close();
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
}