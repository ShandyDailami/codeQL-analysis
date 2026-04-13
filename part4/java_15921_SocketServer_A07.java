import java.io.*;
import java.net.*;

public class java_15921_SocketServer_A07 {
    private static final int port = 8080;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Starting server on port " + port);

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client at " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                if ("A07_AuthFailure".equals(request)) {
                    out.writeUTF("Authentication failure");
                    out.flush();
                } else {
                    out.writeUTF("Unknown request");
                    out.flush();
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            }
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Server stopped");
    }
}