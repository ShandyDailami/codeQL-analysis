import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_31970_SocketServer_A07 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws Exception {

        int port = 8080;

        // Create a server socket and a new executor service
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();

        // Start accepting connections
        startAcceptingConnections(port);
    }

    private static void startAcceptingConnections(int port) {

        while (true) {
            try {
                // Accept a new connection
                Socket clientSocket = serverSocket.accept();

                // Create a new thread for handling the client
                executor.execute(new ClientHandler(clientSocket));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_31970_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {

            try {
                SSLServerSocket sslServerSocket = (SSLServerSocket) clientSocket.getSocket();
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.writeBytes("OK\n");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}