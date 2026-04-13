import java.io.*;
import java.net.*;

public class java_22748_SocketServer_A01 {
    private static final int PORT = 4445; // choose a port
    private static boolean running = true;

    public static void main(String args[]) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started.");
            while (running) {
                Socket socket = server.accept();
                System.out.println("Client connected.");
                ClientHandler ch = new ClientHandler(socket);
                ch.start();
            }
            server.close();
        } catch (IOException e) {
            server.close();
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_22748_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            closeConnection();
            e.printStackTrace();
        }
    }

    public void run() {
        String clientMessage;
        try {
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                out.println(clientMessage);
            }
        } catch (IOException e) {
            closeConnection();
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        running = false;
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}