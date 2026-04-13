import java.io.*;
import java.net.*;
import java.util.*;

public class java_39674_SocketServer_A07 {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Perform authentication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String username = in.readUTF();

                if (authenticate(username)) {
                    out.writeUTF("Authentication successful!");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed!");
                    out.flush();
                    socket.close();
                    System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected");
                    continue;
                }

                // Handle communication with client
                DataHandler handler = new DataHandler(in, out);
                new HandlerThread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Simulate authentication by checking if username is "admin"
    private static boolean authenticate(String username) {
        return "admin".equals(username);
    }

    private static class HandlerThread extends Thread {
        private DataHandler handler;

        public java_39674_SocketServer_A07(DataHandler handler) {
            this.handler = handler;
        }

        public void run() {
            try {
                while (true) {
                    String message = handler.readUTF();
                    if ("exit".equals(message)) {
                        handler.close();
                        System.out.println("Client " + handler.getRemoteSocketAddress() + " disconnected");
                        break;
                    }

                    System.out.println("Received: " + message);
                    String response = "Server: " + message;
                    handler.writeUTF(response);
                    handler.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}