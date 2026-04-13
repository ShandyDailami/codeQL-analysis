import java.io.*;
import java.net.*;

public class java_03799_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // specify port number
        int port = 8080;

        // create server socket
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            // accept client connection
            Socket socket = serverSocket.accept();

            // create new thread for client
            Thread thread = new Thread(new ClientHandler(socket));

            // start new thread
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03799_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // receive message from client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF();

            // process message (e.g., echo back to client)
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Server received: " + message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}