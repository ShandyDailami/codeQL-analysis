import java.io.*;
import java.net.*;

public class java_30146_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected.");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_30146_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read from the client
            String input = in.readLine();

            // Echo the message back to the client
            out.println("Server: " + input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}