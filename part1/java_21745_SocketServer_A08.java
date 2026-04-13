import java.io.*;
import java.net.*;
import java.util.*;

public class java_21745_SocketServer_A08 {
    private static ArrayList<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);

                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication with this client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_21745_SocketServer_A08(Socket socket) {
            this.socket = socket;

            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;

            while ((message = readMessage()) != null) {
                System.out.println("Received: " + message);

                // Simulate integrity failure
                if (message.equals("A08_IntegrityFailure")) {
                    try {
                        dos.writeUTF("IntegrityFailure");
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            closeConnection();
        }

        private String readMessage() {
            String message = null;

            try {
                message = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return message;
        }

        private void closeConnection() {
            clientSockets.remove(socket);

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}