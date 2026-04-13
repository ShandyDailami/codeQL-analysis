import java.io.*;
import java.net.*;

public class java_37498_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server started at " + server.getLocalSocketAddress());
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handling client by creating a new thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_37498_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Received: " + request);

                // Here we simulate a failed authentication.
                if (request.contains("bad_request")) {
                    writer.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
                    writer.flush();
                    System.out.println("Authentication failed. Client disconnected.");
                    socket.close();
                    return;
                }

                // Here we simulate a successful authentication.
                if (request.contains("good_request")) {
                    writer.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                    writer.flush();
                    System.out.println("Authentication successful. Client disconnected.");
                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}