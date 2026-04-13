import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11514_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle client connection in a new thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_11514_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read request from client
            // Here, we're simply echoing the request back to the client
            socket.getInputStream().read();
            socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
            socket.getOutputStream().write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
            socket.getOutputStream().write("\r\n".getBytes());
            socket.getOutputStream().write("Hello, Client!".getBytes());
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}