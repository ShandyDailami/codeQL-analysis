import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37304_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // port number
            System.out.println("Server started on port 5000");

            while (true) {
                Socket socket = serverSocket.accept(); // waits for a client to connect
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                HandleClientThread thread = new HandleClientThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_37304_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client here using the socket
        // For simplicity, we'll just echo back any received data
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write(socket.getInputStream().read());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}