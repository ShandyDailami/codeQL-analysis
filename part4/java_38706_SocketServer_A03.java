import java.net.ServerSocket;
import java.net.Socket;

public class java_38706_SocketServer_A03 {
    private static final int PORT = 1234; // choose a port number

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept(); // waits for a client
                System.out.println("A client has connected!");

                // handle client
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
       .
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_38706_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // here you can implement your server logic
        // for example, you can read a message from the client and echo it back
        try {
            // read from the client
            socket.getInputStream().read();
            // write to the client
            socket.getOutputStream().write("Received your message!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}