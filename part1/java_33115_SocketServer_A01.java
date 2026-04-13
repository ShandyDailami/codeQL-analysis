import java.io.*;
import java.net.*;

public class java_33115_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the communication with the client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_33115_SocketServer_A01(Socket socket) {
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

                // Simulate a security-sensitive operation
                if (clientMessage.equals("DangerousCommand")) {
                    writer.println("Access Denied");
                    System.out.println("Access Denied");
                    break;
                }

                writer.println("Server response");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}