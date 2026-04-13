import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_07582_SocketServer_A01 {
    private static SSLServerSocket sslServerSocket;

    public static void main(String[] args) {
        // Create a SSLServerSocket and bind it to the port
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);
            serverSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Accept each connection and handle it in a new thread
        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for handling the connection
                new HandlerThread(sslSocket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class HandlerThread extends Thread {
        private final SSLSocket socket;

        public java_07582_SocketServer_A01(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    // Send a response back to the client
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Hello, Client!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}