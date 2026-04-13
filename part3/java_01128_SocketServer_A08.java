import java.io.*;
import java.net.*;
import java.util.*;

public class java_01128_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server started on port 6666");
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        public java_01128_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }
        public void run() {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    // Here we are only checking the message for integrity, no encryption, so it's a simple pass-through for demonstration purposes
                    if (message.equals("A08_IntegrityFailure")) {
                        out.writeUTF("A08_IntegrityFailure - Successfully handled");
                    } else {
                        out.writeUTF("Unknown message - Ignored");
                    }
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}