import java.io.*;
import java.net.*;

public class java_08474_SocketServer_A08 {

    // The server socket
    private ServerSocket serverSocket;

    public java_08474_SocketServer_A08(int port) throws IOException {
        // Create a server socket on the specified port
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + "...");

        while (true) {
            try {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Handle the client connection, handle communication securely
                handleClient(clientSocket);

            } catch (IOException ex) {
                ex.printStackTrace();
                continue;
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        // Create a input stream from the client socket for reading
        try (InputStream input = clientSocket.getInputStream()) {

            // Create a reader from the input stream for easier reading
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Print out the message sent by the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            try (OutputStream output = clientSocket.getOutputStream()) {
                output.write(("HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=utf-8\r\n" +
                        "\r\n" +
                        "This is a secure server! Hooray for A08_IntegrityFailure!").getBytes());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8080).startServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}