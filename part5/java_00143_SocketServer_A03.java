import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00143_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected");

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // clean up resources
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_00143_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // read from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();

            // process the message
            // for now, just send a response
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client, you sent: " + message);

            // close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}