import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_15044_SocketServer_A03 {

    private static final int PORT = 8888;
    private SSLServerSocket serverSocket;

    public java_15044_SocketServer_A03() throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        serverSocket.setNeedClientAuthentication(true);
    }

    public void startServer() throws IOException {
        System.out.println("Server started at port " + PORT);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            SSLSession session = clientSocket.getSession();
            System.out.println("New client connected: " + session.getPeerHost() + " : " + session.getPeerPort());

            // Create reader and writer for the client socket
            OutputStream outToClient = clientSocket.getOutputStream();
            InputStream inFromClient = clientSocket.getInputStream();

            // Thread for handling client requests
            Thread handler = new Thread(new SocketHandler(inFromClient, outToClient));
            handler.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().startServer();
    }
}

class SocketHandler implements Runnable {
    private InputStream inFromClient;
    private OutputStream outToClient;

    public java_15044_SocketServer_A03(InputStream inFromClient, OutputStream outToClient) {
        this.inFromClient = inFromClient;
        this.outToClient = outToClient;
    }

    @Override
    public void run() {
        try {
            // Read request from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(inFromClient));
            PrintWriter writer = new PrintWriter(outToClient, true);

            String clientRequest;
            while ((clientRequest = reader.readLine()) != null) {
                System.out.println("Received request from client: " + clientRequest);

                // Send response back to client
                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/plain; charset=utf-8");
                writer.println();
                writer.println("Hello, client!");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}