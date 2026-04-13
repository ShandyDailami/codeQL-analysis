import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01414_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
            System.out.println("Cannot establish server socket.");
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_01414_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: handle client communication. You can use socket to send/receive data
        // For example, you can use socket to send a message to the client, or receive data from the client

        // For example, here we are just echoing back any incoming data
        try {
            // Receive data from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                socket.close();
            } else {
                System.out.println("Received message: " + new String(buffer, 0, bytesRead));

                // Send the same data back to the client
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}