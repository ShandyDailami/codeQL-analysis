import java.io.*;
import java.net.*;

public class java_21336_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();

                // Here we are creating a new thread for each client connection
                // This is a very basic example and does not involve any security-sensitive operations
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_21336_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Reading the client's message
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received: " + message);

            // Reply with a message
            String response = "Hello, client!";
            out.writeBytes(response + "\n");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}