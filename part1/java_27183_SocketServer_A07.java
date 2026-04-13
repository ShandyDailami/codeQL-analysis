import java.io.*;
import java.net.*;

public class java_27183_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected...");

            // Create a thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_27183_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Receive authentication request from the client
            String request = reader.readLine();

            // Simulate authentication failure by checking request content
            if (request.equals("AuthFailure")) {
                // Write response to the client
                writer.println("AuthFailure: false");
            } else {
                writer.println("Unknown request");
            }

            // Close the connection
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}