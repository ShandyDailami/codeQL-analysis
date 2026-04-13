import java.io.*;
import java.net.*;

public class java_37628_SocketServer_A08 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            while (true) {
                System.out.println("Waiting for client...");
                socket = server.accept();
                System.out.println("Client connected");
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_37628_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                String serverMessage = "Server says: " + clientMessage;
                writer.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}