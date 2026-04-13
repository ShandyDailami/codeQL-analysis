import java.net.*;
import java.io.*;

public class java_25702_SocketServer_A07 {

    private static final int port = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new Handler(socket).start();
            }

        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
       
        }
    }
}

class Handler extends Thread {
    private Socket socket;
    public java_25702_SocketServer_A07(Socket socket) {
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

            String response = "Message received!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();

        } catch (IOException e) {
            System.out.println("Error in client handling: " + e.getMessage());
        }
    }
}