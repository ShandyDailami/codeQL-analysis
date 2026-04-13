import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31593_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_31593_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Assuming authentication happens through a secure channel
            // Here we are using a simple username and password authentication
            String username = socket.getInputStream().readUTF();
            String password = socket.getInputStream().readUTF();

            if ("username".equals(username) && "password".equals(password)) {
                socket.getOutputStream().writeUTF("authenticated");
            } else {
                socket.getOutputStream().writeUTF("failed");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}