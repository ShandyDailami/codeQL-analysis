import java.io.*;
import java.net.*;
import java.util.*;

public class java_38691_SocketServer_A01 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket at port 8080
            serverSocket = new ServerSocket(8080);

            while (true) {
                // Wait for a client to connect
                socket = serverSocket.accept();

                // Create a new thread to handle communication with the client
                new Handler(socket).start();
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

class Handler extends Thread {

    private Socket socket;

    public java_38691_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        // Create input and output streams
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Wait for client message
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            // Send back a message to client
            out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}