import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07616_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has connected");

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_07616_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Receive message from client
            byte[] buffer = new byte[1024];
            socket.receive(buffer);

            // Process the message (Authentication)
            String message = new String(buffer);
            if (message.equals("A07_AuthFailure")) {
                // Here you can implement the security-sensitive operations related to A07_AuthFailure
                // For example, you can use SSL/TLS for secure communication
                // ...
                // Send response back to client
                socket.sendBytes("A07_AuthSuccess".getBytes());
            } else {
                socket.sendBytes("A07_AuthFailure".getBytes());
            }

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}