import java.io.*;
import java.net.*;

public class java_12043_SocketServer_A01 {

    private static final String MESSAGE = "Hello, Client!";
    private static final int PORT = 1234;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_12043_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(MESSAGE);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}