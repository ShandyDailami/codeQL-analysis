import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38063_SocketServer_A07 {
    private static final int PORT = 4445; // Choose an arbitrary unprivileged port

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_38063_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can handle the client data. You may want to add authentication here.
            // For now, let's assume we only want to authenticate the client.
            socket.getInputStream().read();

            System.out.println("Client authenticated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}