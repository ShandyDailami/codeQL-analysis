import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30277_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30277_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Write your logic here
            // For now, we'll just forward the request to the client
            socket.getOutputStream().write(("HTTP/1.1 200 OK\n" +
                    "Content-Type: text/plain; charset=utf-8\n" +
                    "Connection: close\n\n" +
                    "Hello, Client\n\n").getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}