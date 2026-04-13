import java.net.ServerSocket;
import java.net.Socket;

public class java_31626_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Here you can handle the client connection.
            // For instance, you can start a new thread to handle the client's request.
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    Socket socket;

    public java_31626_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the request here using socket
        // For instance, you can read the request from the client and send a response back
        try {
            // Here you can use the socket to read from the client and write to the client
            // For instance, you can read a line from the client and send a line back
            socket.getInputStream().read();
            socket.getOutputStream().println("Received your message");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}