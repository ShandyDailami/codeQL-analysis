import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15554_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 12345; // default port
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            // Here we are creating a new thread for each client connection
            new Handler(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (server != null) {
                try { server.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    static class Handler extends Thread {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here we can add the code to handle the communication with the client
            // For the sake of simplicity, we'll just print out the client's message
            try {
                String message = "Hello Client, You connected to the server.";
                socket.getOutputStream().write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}