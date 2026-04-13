import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_33644_SocketServer_A08 {

    private final SSLServerSocket serverSocket;

    public java_33644_SocketServer_A08(int port) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        serverSocket.setNeedClientAuth(true);
    }

    public void start() throws IOException {
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
        handleClient(clientSocket);
        clientSocket.close();
    }

    private void handleClient(SSLSocket client) throws IOException {
        Thread thread = new Thread(() -> {
            try {
                InputStream inputStream = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                OutputStream outputStream = client.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                String request;
                while ((request = reader.readLine()) != null) {
                    if (request.equalsIgnoreCase("exit")) {
                        writer.println("Exiting chat room");
                        break;
                    } else {
                        writer.println("Received: " + request);
                    }
                }
                writer.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public static void main(String[] args) throws IOException {
        SSLServer server = new SSLServer(8000);
        server.start();
    }
}