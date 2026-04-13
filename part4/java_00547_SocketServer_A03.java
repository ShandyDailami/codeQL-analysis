import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00547_SocketServer_A03 {

    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    public static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while(true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    private static void handleClient(Socket clientSocket) {
        System.out.println("New client connected");
        // Handle the client here. For simplicity, we'll just echo back the client's messages
        new EchoHandler(clientSocket).start();
    }

    private static void stopServer() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoHandler extends Thread {
    private final Socket socket;

    public java_00547_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // Write to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while((message = in.readLine()) != null) {
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}