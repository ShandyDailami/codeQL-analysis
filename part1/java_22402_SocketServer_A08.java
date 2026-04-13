import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_22402_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        int port = 5000;

        // Create a server socket
        Socket serverSocket = new Socket("localhost", port);

        // Create input and output streams
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        // Create a new thread for handling client requests
        new ClientHandler(in, out).start();

        // Read client's message and echo it back
        String message;
        while ((message = in.readLine()) != null) {
            out.println(message);
        }

        // Close the connection
        serverSocket.close();
    }
}

class ClientHandler extends Thread {
    private BufferedReader in;
    private PrintWriter out;

    public java_22402_SocketServer_A08(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}