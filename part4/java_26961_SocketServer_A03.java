import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26961_SocketServer_A03 {

    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {

        // Step 1: Initialize executorService
        executorService = Executors.newFixedThreadPool(10);

        // Step 2: Create server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running on port 8080");

        while (true) {
            // Step 3: Accept a new connection
            Socket clientSocket = serverSocket.accept();

            // Step 4: Create a new thread for the client connection
            HandlerThread handlerThread = new HandlerThread(clientSocket);
            executorService.execute(handlerThread);
        }
    }

    // HandlerThread is a thread-safe component that allows you to handle multiple client connections in parallel.
    static class HandlerThread implements Runnable {
        private Socket socket;

        public java_26961_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Step 5: Send a welcome message to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello, you connected to the server!");

                // Step 6: Receive data from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    // Step 7: Process the input data (this is a placeholder for a real application)
                    System.out.println("Received: " + inputLine);

                    // Step 8: Send a response back to the client
                    out.println("Server response: " + inputLine);
                }

                // Step 9: Close the connection
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}