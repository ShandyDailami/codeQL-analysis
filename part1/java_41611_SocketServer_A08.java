import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41611_SocketServer_A08 {
    private static final int PORT = 65432;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client connected");

                // Create a new thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_41611_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams
            SocketClientHandler clientHandler = new SocketClientHandler(clientSocket);

            // Send a message to the client
            clientHandler.send("Welcome to the server!");

            // Receive the encrypted message from the client
            String message = clientHandler.receive();

            // Decrypt the message
            message = decrypt(message);

            System.out.println("Received encrypted message: " + message);
        } catch (IOException e) {
            System.out.println("Error handling client connection");
            e.printStackTrace();
        }
    }

    private String decrypt(String encrypted) {
        StringBuilder builder = new StringBuilder();

        for (char ch : encrypted.toCharArray()) {
            builder.append((char) (ch ^ 'A'));
        }

        return builder.toString();
    }
}

class SocketClientHandler {
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public java_41611_SocketServer_A08(Socket socket) throws IOException {
        this.clientSocket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public void send(String message) throws IOException {
        out.writeUTF(message);
    }

    public String receive() throws IOException {
        String message = in.readUTF();
        return message;
    }
}