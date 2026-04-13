import java.io.*;
import java.net.*;

public class java_26088_SocketServer_A03 {

    private static final String PORT_STRING = "8888"; // Change this to the port you want to use
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            // create a new ServerSocket
            serverSocket = new ServerSocket(Integer.parseInt(PORT_STRING));
            System.out.println("Server started at port: " + PORT_STRING);

            // wait for client to connect
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // create a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    private static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ClientHandler class to handle a client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_26088_SocketServer_A03(Socket socket) {
            this.socket = socket;
            setupStreams();
        }

        private void setupStreams() {
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
                String message;
                // read the message from the client
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // simulate a security-sensitive operation (e.g., checking for injection)
                    if (checkInjection(message)) {
                        System.out.println("Security-sensitive operation detected, closing connection");
                        socket.close();
                        return;
                    }

                    // send the message back to the client
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Simulate a security-sensitive operation (e.g., checking for injection)
        private boolean checkInjection(String message) {
            // Implement your own logic here
            // This is a placeholder and will not actually perform any checks.
            return false;
        }
    }
}