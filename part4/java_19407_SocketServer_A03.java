import java.io.*;
import java.net.*;

public class java_19407_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected!");

            // Handle the client connection in a new thread
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_19407_SocketServer_A03(Socket socket) {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        String message;
        try {
            // Receive a message from the client
            message = in.readLine();

            // Handle the message in a secure way
            message = filterMessage(message);

            // Send the message back to the client
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String filterMessage(String message) {
        // Implement the security-sensitive operations related to A03_Injection here
        // For now, we'll just return the message unmodified
        return message;
    }
}