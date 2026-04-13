import java.io.*;
import java.net.*;

public class java_31971_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Creating new thread for handling each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable, RejectHandler {
    private Socket socket;

    public java_31971_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            while (true) {
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("close")) {
                    break;
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rejectedExecution(Runnable r, RejectExecutor executor) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

interface RejectHandler extends RejectExecutor {
    void rejectedExecution(Runnable r, RejectExecutor executor);
}

interface RejectExecutor {
    void rejectedExecution(Runnable r, RejectExecutor executor);
}