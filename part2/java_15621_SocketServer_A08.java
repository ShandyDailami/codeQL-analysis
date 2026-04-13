import java.io.*;
import java.net.*;

public class java_15621_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                // create new thread for each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    public java_15621_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);
            OutputStream output = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);
            String serverMessage = "Hello, client!";
            dos.writeUTF(serverMessage);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}