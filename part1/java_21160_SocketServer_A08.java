import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21160_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create a new thread to handle the request
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port: " + PORT);
       
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_21160_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the request from the client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String request = new String(bytes);

            // Process the request (e.g., integrity failure)
            if (request.contains("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected in request: " + request);
                // Here, we'll just return a simple response
                socket.getOutputStream().write("IntegrityFailureResponse".getBytes());
            } else {
                // For other requests, just send a simple response
                socket.getOutputStream().write("SuccessResponse".getBytes());
            }

            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}