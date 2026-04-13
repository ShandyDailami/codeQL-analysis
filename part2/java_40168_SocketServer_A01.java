import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40168_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started, waiting for connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client has connected: " + clientSocket.getInetAddress().getHostAddress());

            // Now, handle the client connection
            // For the sake of simplicity, we'll just echo back the client's message
            new EchoHandler(clientSocket).start();
        }
    }
}

class EchoHandler extends Thread {
    private final Socket socket;

    public java_40168_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive and echo back the request
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String request = new String(buffer);
            System.out.println("Received: " + request);

            // Echo the request back
            byte[] response = request.getBytes();
            socket.getOutputStream().write(response);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}