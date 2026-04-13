import java.io.*;
import java.net.*;

public class java_23982_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started at port 8000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected at " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public java_23982_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Receive request from client
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Process request
            String response = processRequest(request);

            // Send response back to client
            writer.write(response.getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // Simulate a security sensitive operation related to injection using a simple String concatenation
        return "Response from server: " + request;
    }
}