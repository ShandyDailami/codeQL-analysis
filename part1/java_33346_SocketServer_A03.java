import java.net.*;
import java.io.*;

public class java_33346_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 4445;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public java_33346_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = dis.readUTF();
            System.out.println("Received: " + request);

            // Send response back to client
            dos.writeUTF("Hello, client!");
            System.out.println("Sent: " + "Hello, client!");

            // Close connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}