import java.io.*;
import java.net.*;

public class java_36177_SocketServer_A01 {
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_36177_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            if ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // simple security-sensitive operation: print a message to the client
                out.println("Security alert: received unauthorized access attempt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}