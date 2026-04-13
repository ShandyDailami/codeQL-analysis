import java.io.*;
import java.net.*;

public class java_02138_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080.");

            while (true) {
                Socket client = server.accept();
                System.out.println("A client connected.");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {

        Socket client;

        public java_02138_SocketServer_A08(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Create a new input stream and output stream for the client
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                // Continuously read and send messages to the client
                while ((message = in.readLine()) != null) {
                    if (message.equals("exit")) {
                        out.println("You have disconnected from the server.");
                        client.close();
                        break;
                    }

                    // Implementing simple integrity check:
                    // If the length of the received message is not 10, the server sends a failure message back to the client
                    // In the real-life scenario, a real server would not need to check the integrity of the message,
                    // it would just simply send it back to the client.
                    if (message.length() != 10) {
                        out.println("Invalid message length. Server failure.");
                        break;
                    }

                    out.println("Message received: " + message);
                }

                // Close the client's input and output streams
                in.close();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}