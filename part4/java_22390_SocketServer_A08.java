import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22390_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // port number
            System.out.println("Waiting for client...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Here you would typically have a thread-safe way to handle the connection.
                // For simplicity, we'll just start a new thread for each connection
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_22390_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you would handle the client communication in a thread-safe way
        // For simplicity, we'll just echo the received data back to the client
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write("Echo: ".getBytes());
                socket.getOutputStream().write(socket.getInputStream().readAllBytes());
                socket.getOutputStream().flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}