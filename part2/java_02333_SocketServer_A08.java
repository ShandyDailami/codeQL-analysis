import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02333_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

                // Create a new thread for each connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_02333_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send welcome message
            out.println("Welcome to the server!");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Process the message here (e.g., save to database)
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}