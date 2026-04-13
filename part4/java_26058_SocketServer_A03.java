import java.net.*;
import java.io.*;

public class java_26058_SocketServer_A03 {

    private ServerSocket serverSocket;

    public java_26058_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for handling each client
            Thread clientHandler = new Thread(new ClientHandler(clientSocket));
            clientHandler.start();
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).startServer();
    }

    // Inner class for handling individual clients
    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_26058_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simple example of a form of injection
                    // This code is only here to illustrate the concept,
                    // and it intentionally leaves the message in the system
                    // in a state that might be exploited by attackers.
                    String injection = "Injection: " + message;
                    System.out.println("Injection attempt: " + injection);

                    // This line should normally not be executed
                    // It's here to show the concept of a potential injection
                    // attack, where an attacker could potentially manipulate the system
                    // by sending a message that looks like it might be a valid
                    // SQL statement or similar.
                    // This is a very simplified example, and in a real application
                    // you would likely use a more sophisticated method to handle
                    // the message.
                    System.out.println("Sending back: " + injection);
                    out.println(injection);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}