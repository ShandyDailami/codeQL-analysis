import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34101_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected!");

            // create new thread for each connected client
            new Thread(new ClientHandler(socket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_34101_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read the username from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String username = reader.readLine();
            System.out.println("Received username: " + username);

            // perform some security sensitive operation
            // e.g., send the username back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(username);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}