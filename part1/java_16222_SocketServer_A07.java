import java.io.*;
import java.net.*;

public class java_16222_SocketServer_A07 {
    private static int port = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

                // Perform client handshake
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Client's first message should be the server's public key
                out.writeUTF("Server's public key: " + socket.getInetAddress().getHostAddress() + "\n");
                String clientKey = in.readUTF();

                // If client's key does not match the server's public key, abort handshake
                if (!clientKey.equals("Server's public key: " + socket.getInetAddress().getHostAddress())) {
                    System.out.println("Client handshake failed: " + clientKey);
                    out.writeUTF("Handshake failed\n");
                    out.flush();
                    socket.close();
                    continue;
                }

                // If client's key matches the server's public key, continue handshake
                out.writeUTF("Handshake succeeded\n");
                out.flush();

                // Client can now send and receive messages
                Thread sendThread = new Thread(new SendThread(socket, out));
                Thread receiveThread = new Thread(new ReceiveThread(in));
                sendThread.start();
                receiveThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thread for sending messages to a client
    static class SendThread implements Runnable {
        private Socket socket;
        private DataOutputStream out;

        public java_16222_SocketServer_A07(Socket socket, DataOutputStream out) {
            this.socket = socket;
            this.out = out;
        }

        public void run() {
            try {
                while (true) {
                    String message = "Hello, Client! Message from " + socket.getInetAddress();
                    out.writeUTF(message);
                    out.flush();
                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread for receiving messages from a client
    static class ReceiveThread implements Runnable {
        private DataInputStream in;

        public java_16222_SocketServer_A07(DataInputStream in) {
            this.in = in;
        }

        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}