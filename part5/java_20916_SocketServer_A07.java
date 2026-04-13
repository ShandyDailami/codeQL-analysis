import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20916_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // listen on port 1234
            while (true) {
                Socket socket = serverSocket.accept(); // wait for connection
                System.out.println("Client connected");

                // handle the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_20916_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle client communication
        // for simplicity, we'll just print out what the client says
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}