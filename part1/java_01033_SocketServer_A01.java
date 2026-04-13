import java.io.*;
import java.net.*;

public class java_01033_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Server port
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept(); // Accepting a new client
            System.out.println("A client connected!");

            // Creating a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_01033_SocketServer_A01(Socket socket) {
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
                writer.writeBytes("Message received\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}