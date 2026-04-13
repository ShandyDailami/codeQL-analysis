import java.io.*;
import java.net.*;

public class java_02870_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Creating new threads for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_02870_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.writeBytes("Echo: " + message + "\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}