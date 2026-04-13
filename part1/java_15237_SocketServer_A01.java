import java.io.*;
import java.net.*;

public class java_15237_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 5000;

        // create a server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                // accept a new client
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // create a new thread for each client
                Handler handler = new Handler(clientSocket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}

class Handler implements Runnable {

    private Socket socket;

    public java_15237_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            // read from the client
            int request;
            while ((request = in.read()) != -1) {
                System.out.println("Received: " + request);

                // send a response
                out.write(request);
                out.flush();
            }

        } catch (IOException ex) {
            System.out.println("Error handling client: " + ex.getMessage());
        }
    }
}