import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14037_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle the client in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_14037_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the client's request here
        // In real scenario, you should use a BufferedReader and PrintWriter for communication
    }
}