import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28003_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Handle each client separately
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_28003_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle each client separately
            // In this example, we'll just echo back the message
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                socket.getOutputStream().write(buffer);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}