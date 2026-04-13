import java.io.*;
import java.net.*;
import java.util.*;

public class java_34323_SocketServer_A03 {

    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Secure Socket Server is listening on port " + PORT + " ...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            // create a new thread for each client
            Thread thread = new Thread(new SocketServerThread(socket));
            thread.start();
        }
    }
}

class SocketServerThread implements Runnable {
    private Socket socket;

    public java_34323_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            // read the client's message
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // send back a message
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());

        } catch (IOException ex) {
            System.out.println("Error in communication: " + ex);
            ex.printStackTrace();
        }
    }
}