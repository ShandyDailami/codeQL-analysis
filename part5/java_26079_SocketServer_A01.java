import java.net.*;
import java.io.*;

public class java_26079_SocketServer_A01 {

    private static int port = 12345;

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Error establishing server socket: " + e.getMessage());
       
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_26079_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Error setting up I/O streams: " + e.getMessage());
        }
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}