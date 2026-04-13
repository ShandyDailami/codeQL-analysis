import java.io.*;
import java.net.*;

public class java_41628_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_41628_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here, we are simulating a security-sensitive operation.
                // The operation is to check if the received message is valid.
                // In a real-world scenario, this operation would be more complex.
                if(isValid(message)) {
                    out.println("Valid message received. Sending back to client.");
                    out.println("Received: " + message);
                } else {
                    out.println("Invalid message received. Dropping it.");
                }
            }

            // Close the streams and the socket connection
            socket.close();

        } catch(IOException e) {
            System.out.println("Client disconnected");
        }
    }

    // This method is a placeholder for the real security-sensitive operation.
    // In a real-world scenario, this operation would be more complex.
    private boolean isValid(String message) {
        // Simulating security-sensitive operation
        return message.equals("Valid message");
    }
}