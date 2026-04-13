import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36019_SocketServer_A03 {
    private static final int PORT = 12345; // chosen port

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in server: " + e.getMessage());
            serverSocket.close();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_36019_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your code to handle the client's request
            // For now, we'll just echo back the data received from the client

            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}