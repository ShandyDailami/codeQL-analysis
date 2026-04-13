import java.io.*;
import java.net.*;

public class java_16606_SocketServer_A08 implements Runnable {

    private int port;
    private ServerSocket serverSocket;

    public java_16606_SocketServer_A08(int port) {
        this.port = port;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
       
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing server socket");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting server on port 8080");
        new SocketServer(8080).run();
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public java_16606_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error getting input/output streams");
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            out.println("Welcome to the server!");
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Simple integrity check. If the client sends a message that is not 'Hello',
                // it's considered a failure.
                if (!message.equals("Hello")) {
                    System.out.println("Client sent: " + message + ". Stopping client.");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error with client");
            e.printStackTrace();
        }
    }
}