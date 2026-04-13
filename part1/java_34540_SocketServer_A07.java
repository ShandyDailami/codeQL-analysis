import java.io.*;
import java.net.*;

public class java_34540_SocketServer_A07 {
    private static int port = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                handleClient(socket);
           
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read username
            String username = in.readUTF();
            System.out.println("Received: " + username);

            // Read password
            String password = in.readUTF();

            // Check if password matches (This is a very simple check, in a real application you would need a more secure way)
            if (password.equals("securePassword")) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            out.close();
            in.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}