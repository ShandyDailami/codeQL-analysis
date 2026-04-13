import java.io.*;
import java.net.*;

public class java_39034_SocketServer_A08 {
    private static int portNumber = 5000;
    private static ServerSocket serverSocket;
    private static boolean serverRunning = true;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started on port " + portNumber);

            while (serverRunning) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_39034_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    // Simulate a security-sensitive operation
                    if (message.equals("A08_IntegrityFailure")) {
                        System.out.println("Detected a security failure, closing connection");
                        clientSocket.close();
                    }
                }

                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}