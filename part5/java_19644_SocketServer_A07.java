import java.io.*;
import java.net.*;

public class java_19644_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client is connected!");

            // create new thread for each client
            Thread thread = new Thread(new SocketServerThread(socket));
            thread.start();
        }
    }
}

class SocketServerThread implements Runnable {
    private Socket socket;

    public java_19644_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            OutputStream output = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            String message;

            while ((message = dis.readUTF()) != null) {
                System.out.println("Client says: " + message);
                dos.writeUTF("Thank you for connecting to the server. Your message was: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}