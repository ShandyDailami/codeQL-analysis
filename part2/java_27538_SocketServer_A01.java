import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_27538_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Start the server
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the client request
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_27538_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Get the input and output streams from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Read a line of text from the client
                String request = in.readLine();

                // Process the request and send a response back to the client
                out.println("Server received: " + request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}