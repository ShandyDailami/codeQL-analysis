import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00516_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here, you can add your security-sensitive operations related to A01_BrokenAccessControl

                // But to be creative, let's add a simple echo server functionality
                new EchoServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoServerThread extends Thread {
    private Socket socket;

    public java_00516_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from the socket
            byte[] bytes = new byte[1024];
            int bytesRead = socket.getInputStream().read(bytes);
            if (bytesRead < 0) {
                socket.close();
                return;
            }

            // Write to the socket
            socket.getOutputStream().write(bytes, 0, bytesRead);
            socket.getOutputStream().flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}