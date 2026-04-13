import java.io.*;
import java.net.*;

public class java_24471_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_24471_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            OutputStream output = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            dos.writeUTF("Server received your message");
            dos.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}