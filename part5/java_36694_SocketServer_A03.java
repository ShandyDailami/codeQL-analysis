import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36694_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_36694_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get input and output streams
            java.io.InputStream input = this.socket.getInputStream();
            java.io.OutputStream output = this.socket.getOutputStream();

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}