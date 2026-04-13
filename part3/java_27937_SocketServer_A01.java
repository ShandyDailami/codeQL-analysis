import java.io.*;
import java.net.*;

public class java_27937_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread for handling the client request
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_27937_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            String data = dis.readUTF();
            System.out.println("Received: " + data);

            dos.writeUTF("Message received");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}