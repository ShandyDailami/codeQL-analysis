import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26795_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client connection in a new thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_26795_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client request here
        // For simplicity, we'll just echo back any incoming data
        try {
            while ((socket.getInputStream().read()) != -1) ;
            socket.getOutputStream().write("Hello World\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}