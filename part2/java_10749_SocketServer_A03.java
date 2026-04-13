import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10749_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        executor = Executors.newFixedThreadPool(5);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            ClientHandler client = new ClientHandler(socket);
            executor.execute(client);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_10749_SocketServer_A03(Socket socket) {
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
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Perform some security-sensitive operation related to A03_Injection
                // Here, we're just echoing the received message back to the client
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}