import java.io.*;
import java.net.*;

public class java_26844_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Start a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_26844_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String clientMessage;
        while ((clientMessage = readMessage()) != null) {
            processMessage(clientMessage);
        }
    }

    private String readMessage() {
        String message = null;
        try {
            message = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    private void processMessage(String message) {
        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure
        // For example, verify if the message is valid
        // If the message is not valid, respond with an error message

        // For simplicity, we'll just echo back the message
        writeMessage("Server received: " + message);
    }

    private void writeMessage(String message) {
        writer.println(message);
        writer.flush();
    }
}