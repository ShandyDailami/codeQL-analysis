import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_12903_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocket server = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket = server;

            // Create a thread for each client that connects to the server
            while (true) {
                SSLSocket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final SSLServerSocket serverSocket;

        public java_12903_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.serverSocket = (SSLServerSocket) socket.getServerSocket();
        }

        @Override
        public void run() {
            try {
                SSLSocket sock = (SSLSocket) socket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(sock.getInputStream()));

                DataOutputStream out = new DataOutputStream(sock.getOutputStream());

                // Get the certificate information
                Certificate certificate = sock.getCertificate().getCertificate();
                String certInfo = new String(certificate.toString().getBytes());

                // Output certificate information
                out.writeBytes("Certificate Information: " + certInfo + "\n");

                // Send back a random number for verification
                out.writeBytes("Your random number is: " + (Math.random() * 1000) + "\n");

                sock.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}