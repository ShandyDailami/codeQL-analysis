import java.io.*;
import java.net.*;

public class java_00318_SocketServer_A07 {

    private static final int PORT = 1234;
    private static final String LOCAL_HOST = "localhost";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(LOCAL_HOST, PORT));

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication (Here we're assuming it's a simple username-password system)
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMsg = reader.readLine();
                System.out.println("Received client message: " + clientMsg);

                String serverMsg = "Hello, client";
                writer.writeBytes(serverMsg + "\n");
                writer.flush();

                socket.close();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}