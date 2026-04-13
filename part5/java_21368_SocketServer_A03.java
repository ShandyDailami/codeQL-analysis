import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21368_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create new thread for each client
                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EchoThread extends Thread {
    private Socket socket;

    public java_21368_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive message from client
            byte[] bytes = new byte[1000];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);

            // Send back the message to the client
            socket.getOutputStream().write(bytes);
            socket.getOutputStream().flush();

            System.out.println("Message received: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}