import java.io.*;
import java.net.*;

public class java_39211_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create a new Thread for each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    Socket socket;

    public java_39211_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.writeBytes(message.toUpperCase() + "\n");
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}