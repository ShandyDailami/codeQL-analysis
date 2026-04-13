import java.io.*;
import java.net.*;
import java.util.*;

public class java_11489_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // create thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public java_11489_SocketServer_A03(Socket socket) {
        this.socket = socket;

        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;

        // read message from client
        try {
            message = dis.readUTF();
            System.out.println("Received: " + message);

            // respond to client
            dos.writeUTF("Hello, Client!");
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // close connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}