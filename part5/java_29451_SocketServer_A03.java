import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29451_SocketServer_A03 {
    private static final String PASSWORD = "password"; // Password for the client to connect

    private static Map<String, SSLSocket> clients = new HashMap<>();

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(12345);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                InetAddress address = sslSocket.getInetAddress();

                // Check if the client password is correct
                if (verifyPassword(address, sslSocket)) {
                    clients.put(address.toString(), sslSocket);
                    new ClientHandler(sslSocket).start();
                } else {
                    System.out.println("Wrong password for client " + address.toString());
                    sslSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean verifyPassword(InetAddress address, SSLSocket socket) {
        // In a real-world scenario, you would typically use a more complex method of checking the password
        // This is just a simple check for the sake of this example
        return PASSWORD.equals(socket.getRemoteSocket().getInetAddress().toString());
    }

    private static class ClientHandler extends Thread {
        private final SSLSocket socket;

        public java_29451_SocketServer_A03(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client here
            // This is just a simple example, you would typically read from and write to the socket
            // in a real-world scenario
            try {
                byte[] bytes = new byte[1024];
                int length = socket.getInputStream().read(bytes);
                if (length > 0) {
                    System.out.println(new String(bytes, 0, length));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}