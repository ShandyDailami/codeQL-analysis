import java.net.ServerSocket;
import java.net.Socket;

public class java_39488_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // port number
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (Exception e) {
            System.out.println("Error in server: " + e.getMessage());
       .
.
.
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_39488_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we assume that the client sends a message, checks if it's valid and then closes the connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here we are simulating a security breach by assuming that the client's message is not a valid one
                if (message.equals("Invalid")) {
                    writer.println("Invalid message");
                    writer.flush();
                    socket.close();
                    return;
                }
            }

            writer.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error in client handling: " + e.getMessage());
        }
    }
}