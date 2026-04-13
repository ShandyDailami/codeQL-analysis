import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34669_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here you can handle the socket connections, for example, by creating a new thread for each connection
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_34669_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Here you can handle the socket connections, for example, by creating a new thread for each connection
            new HandlerThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_34669_SocketServer_A08(Socket socket) throws IOException {
        this.socket = socket;
        socket.setTcpNoDelay(true);
        socket.setSoLinger(true, 0);
        socket.setReceiveBufferSize(512 * 1024);
        socket.setSendBufferSize(512 * 1024);
    }

    public void run() {
        // Here you can handle the socket connections, for example, by creating a new thread for each connection
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            System.out.println(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}