import java.io.*;
import java.net.*;
import java.util.*;

public class java_27820_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            clients.add(socket);

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public java_27820_SocketServer_A03(Socket socket) {
        this.socket = socket;

        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String message = input.readUTF();
            System.out.println("Message from client: " + message);

            for (Socket client : clients) {
                output.writeUTF(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}