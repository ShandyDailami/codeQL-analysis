import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_36966_SocketServer_A07 {

    private static SSLServerSocket serverSocket;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Starting server...");

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8090);
            serverSocket.setNeedClientAuth(true);

            while (running) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted client connection from " + clientSocket.getRemoteSocketAddress());

                // Start thread for handling the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private final SSLSocket socket;

        public java_36966_SocketServer_A07(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLPeerPrincipal peerPrincipal = socket.getPeerPrincipal();
                System.out.println("Handshake completed for client " + peerPrincipal.getName());

                socket.setEnabled(true);

                // Perform authentication
                socket.setNeedClientAuth(true);
                socket.setUseClientMode(true);

                // Verify the server's identity
                if (socket.getVerifyServerCertificate()) {
                    System.out.println("Certificate verified successfully");
                } else {
                    System.out.println("Failed to verify certificate");
                }

                // Perform read and write operations
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.write(("Server says: " + inputLine).getBytes());
                    out.newLine();
                    out.flush();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}