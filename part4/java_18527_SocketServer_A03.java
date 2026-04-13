import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18527_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        executor = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());
            executor.execute(new SocketHandler(socket));
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_18527_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                processRequest(request);
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

    private void processRequest(String request) {
        // Add security-sensitive operations related to A03_Injection
        // For example, you can add a check to prevent SQL injection
        // or XSS attacks by escaping special characters.

        // Print the response to the client
        out.println("Server response: " + request);
    }
}