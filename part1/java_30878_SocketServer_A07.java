import java.io.*;
import java.net.*;

public class java_30878_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8080; // default port for server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Create thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Server failed to listen on port " + port);
        }
    }

}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_30878_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {

            // Read and handle the HTTP request
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Generate and send the HTTP response
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain; charset=utf-8\r\n\r\n" +
                    "Hello, World!";
            out.write(response.getBytes());

        } catch (IOException ex) {
            System.out.println("Error handling client " + socket.getInetAddress().getHostName());
        }
    }
}