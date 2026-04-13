import java.io.*;
import java.net.*;

public class java_37775_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_37775_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            // Read the message from the client
            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            // Echo the message back to the client
            OutputStream output = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);
            dos.writeUTF("Server says: " + message);
            dos.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}