import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40836_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000); // listen on port 8000
            System.out.println("Server started on port 8000.");

            while (true) {
                Socket socket = serverSocket.accept(); // wait for client connection
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // handle the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error creating server socket: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_40836_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received message from client: " + message);

            // send back to client
            String response = message.toUpperCase();
            socket.getOutputStream().write(response.getBytes("UTF-8"));

            socket.close(); // close the connection
        } catch (IOException ex) {
            System.out.println("Error handling client connection: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}