import java.io.*;
import java.net.*;

public class java_18897_SocketServer_A01 {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(8001);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for each client
                Thread thread = new Thread(new ServerThread(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public java_18897_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Simulate a security-sensitive operation
            if (message.contains("badword")) {
                System.out.println("Access Denied!");
                out.println("Access Denied!");
            } else {
                out.println("Access Allowed!");
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}