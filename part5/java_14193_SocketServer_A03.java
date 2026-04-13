import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14193_SocketServer_A03 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port: " + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client connection
            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_14193_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Receive a request from the client
            String request = new String(clientSocket.getInputStream().readNBytes(clientSocket.getInputStream().available()), "UTF-8");
            System.out.println("Received request: " + request);

            // TODO: Use a proper library or framework to handle requests
            // For now, simulate a security-sensitive operation
            // This should be replaced by a real security-sensitive operation
            String response = "Response from server: " + request;

            // TODO: Ensure the response is properly encoded and sent back to the client
            // For now, just send the response as is
            clientSocket.getOutputStream().write(response.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}