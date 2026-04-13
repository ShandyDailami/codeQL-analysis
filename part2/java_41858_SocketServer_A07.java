import java.io.*;
import java.net.*;

public class java_41858_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // port number
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept(); // blocking call
                System.out.println("Client connected");

                // create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_41858_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                writer.println("Server received your message: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}