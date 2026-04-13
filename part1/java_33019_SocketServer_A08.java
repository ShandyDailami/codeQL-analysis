import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33019_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());
                
                // Now, you can handle this socket in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    
    public java_33019_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        // Handle client's request in here
        // For simplicity, we're going to just echo back the client's message
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write("Server: Message received\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}