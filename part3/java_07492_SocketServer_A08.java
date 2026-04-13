import java.io.*;
import java.net.*;
import java.util.*;

public class java_07492_SocketServer_A08 {

    // List of clients connected to the server
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            clients.add(socket);

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    // Handler for each client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_07492_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                close();
            }
        }

        public void run() {
            try {
                // Send a welcome message to the client
                out.println("Welcome to the server!");

                String message;
                while ((message = in.readLine()) != null) {
                    // Check the integrity of the message here (this is a placeholder and not secure)
                    if (message.equals("A08_IntegrityFailure")) {
                        // If the message is not valid, close the connection
                        out.println("IntegrityFailure");
                        close();
                    } else {
                        // If the message is valid, echo it back to the client
                        out.println(message);
                    }
                }

                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void close() {
            try {
                clients.remove(socket);
                in.close();
                out.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}