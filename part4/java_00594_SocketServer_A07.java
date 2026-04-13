import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.*;

public class java_00594_SocketServer_A07 {
    private static final int PORT = 1234;
    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(PORT, null, null, SSLServerSocketFactory.getDefaultSSLServerSocketConfig());
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setNeedClientAuth(true);
                SSLCertificate cert = clientSocket.getCertificate();
                System.out.println("Client certificate: " + cert.toString());
                System.out.println("Client IP: " + clientSocket.getRemoteSocketAddress().toString());
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(writer);
                handleClient(clientSocket);
            }
        } catch (IOException | SSLHandshakeException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleClient(SSLSocket clientSocket) {
        new Handler(clientSocket).start();
    }

    private static class Handler extends Thread {
        private final SSLSocket socket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_00594_SocketServer_A07(SSLSocket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                closeConnection();
                System.out.println("Failed to initialize input/output streams: " + e.getMessage());
                return;
            }
            start();
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    sendMessageToAll("Client: " + message);
                }
            } catch (IOException e) {
                closeConnection();
                System.out.println("Failed to read from client: " + e.getMessage());
            }
        }

        private void sendMessageToAll(String message) {
            for (PrintWriter writer : clients) {
                try {
                    writer.println(message);
                } catch (Exception e) {
                    clients.remove(writer);
                    closeConnection();
                    System.out.println("Failed to send message to client: " + e.getMessage());
                    return;
                }
            }
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}