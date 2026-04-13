import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32163_SocketServer_A08 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_32163_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);

                if (bytesRead == -1) {
                    socket.close();
                    System.out.println("Client " + socket.getInetAddress().getHostAddress() + " disconnected");
                    break;
                }

                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message from " + socket.getInetAddress().getHostAddress() + ": " + message);

                socket.getOutputStream().write(message.getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}