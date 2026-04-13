import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23394_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running on port 1234...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Basic security: disallow remote connections
                if (!socket.getRemoteSocketAddress().equals(socket.getLocalSocketAddress())) {
                    System.out.println("Disconnecting remote client...");
                    socket.close();
                } else {
                    // Handle client connection, e.g. start a new thread for each connection
                    new ClientHandler(socket).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_23394_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client requests, e.g. echo back any received data
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write((socket.getInputStream().read()));
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}