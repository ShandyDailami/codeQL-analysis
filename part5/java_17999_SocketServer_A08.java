import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17999_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // port number 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                new SocketHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_17999_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // This is a placeholder, you should replace this with your own logic
        try {
            // Receive a request
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);

            // Send a response
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}