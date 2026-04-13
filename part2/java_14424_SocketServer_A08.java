import java.net.*;
import java.io.*;

public class java_14424_SocketServer_A08 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_SOCKET_PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_SOCKET_PORT);
            System.out.println("Server started on port " + SERVER_SOCKET_PORT + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new Thread(new ServerThread(socket)).start();
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

class ServerThread implements Runnable {
    private Socket socket;

    public java_14424_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);

                // Simple response for demonstration purposes
                writer.write("Hello, client!".getBytes());
                writer.newLine();
                writer.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}