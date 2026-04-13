import java.net.*;
import java.util.concurrent.*;

public class java_16285_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        int port = 8080;

        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            server.close();
        }
    }
}

class Handler implements Runnable {
    private Socket socket;

    public java_16285_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the client's request
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Handle the request (authentication failure)
            if (request.equals("AUTH_FAILURE")) {
                // Return an error response to the client
                String response = "HTTP/1.1 401 Unauthorized\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "Content-Length: 13\r\n" +
                        "\r\n" +
                        "Unauthorized";

                socket.getOutputStream().write(response.getBytes());
            } else {
                // Return a success response to the client
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=UTF-8\r\n" +
                        "Content-Length: 11\r\n" +
                        "\r\n" +
                        "OK";

                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}