import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19215_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(writer);

            // Send a welcome message to the client
            bw.write("Welcome to the server!\r\n");
            bw.flush();

            // Start a new handler thread for this client
            executor.execute(new ClientHandler(socket));
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_19215_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Reader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(reader);

            String message = br.readLine();
            System.out.println("Received: " + message);

            // Check if the client wants to authenticate
            if (message.startsWith("A07_AuthFailure")) {
                // Respond with an unauthenticated message
                Writer writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("Unauthenticated\r\n");
                writer.flush();
            } else {
                // Otherwise, authenticate the client
                writer.write("Authenticated\r\n");
                writer.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}