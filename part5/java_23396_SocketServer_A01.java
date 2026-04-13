import java.io.*;
import java.net.*;

public class java_23396_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for each client connection
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_23396_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            // Handle exceptions here
        }
    }

    @Override
    public void run() {
        String clientMessage;
        while ((clientMessage = reader.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // For security-sensitive operations, we will check if the message contains "bad"
            if (clientMessage.toLowerCase().contains("bad")) {
                System.out.println("Message contains suspicious activity, closing connection.");
                socket.close();
            } else {
                // Echo the message back to the client
                writer.println(clientMessage);
            }
       
            writer.flush();
        }

        // Close the socket when the thread is finished
        socket.close();
    }
}