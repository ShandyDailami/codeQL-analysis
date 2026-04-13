import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15069_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Handle the client connection in a new thread
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_15069_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client and handle it
            // In this example, we just echo back the data
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) return;

            byte[] response = ("HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain; charset=UTF-8\r\n" +
                    "\r\n" +
                    "Hello, World!\r\n").getBytes();
            socket.getOutputStream().write(response);
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}