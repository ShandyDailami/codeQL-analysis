import java.io.*;
import java.net.*;
import java.util.*;

public class java_08192_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_08192_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Receive the client's username
            String username = in.readLine();
            System.out.println("Received username: " + username);

            // Send a welcome message to the client
            out.println("Welcome, " + username + "! Please enter your password to continue.");

            // Receive the client's password
            String password = in.readLine();
            System.out.println("Received password: " + password);

            // Send a success message back to the client
            out.println("Password accepted!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}