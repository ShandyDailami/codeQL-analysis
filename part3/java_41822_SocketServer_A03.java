import java.net.ServerSocket;
import java.net.Socket;

public class java_41822_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_41822_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here is where you would normally read data from the client
            // But in this case, we'll just simulate reading a message from the client
            byte[] bytes = new byte[100];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);
            System.out.println("Received message: " + message);

            // Here is where you would normally send data back to the client
            // But in this case, we'll just simulate sending a message back
            String response = "Message received";
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}