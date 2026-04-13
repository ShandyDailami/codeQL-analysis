import java.io.*;
import java.net.*;

public class java_13367_SocketServer_A03 {

    // Main method to initiate the server
    public static void main(String[] args) {
        int port = 1234; // Set the port number
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while(true) {
                // Accept a new connection
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create a new thread for the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handler for each client
    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_13367_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read from the socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String data;
                while((data = reader.readLine()) != null) {
                    System.out.println("Received: " + data);
                    // Just echo the data back to the client
                    writer.writeBytes(data + "\n");
                }

                // Close the connection
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}