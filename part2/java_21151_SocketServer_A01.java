import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_21151_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Create a socket for the server
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a thread for each client
            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_21151_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                // Get input and output streams from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received client message: " + inputLine);
                    out.println("Server received your message");
                }

                // Close the connection
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}