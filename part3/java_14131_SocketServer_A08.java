import java.io.*;
import java.net.*;

public class java_14131_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected!");

            // Create a new thread for handling each client
            Thread clientHandler = new Thread(new ClientHandler(socket));
            clientHandler.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_14131_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            out.writeUTF("Welcome to the server!");

            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here you can perform any operations related to integrity failure A08_IntegrityFailure
                // For example, you can check if the message contains a specific pattern and handle it accordingly

                // Send a response back to the client
                out.writeUTF("Message received");
            }

            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}