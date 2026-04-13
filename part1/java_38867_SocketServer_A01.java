import java.net.*;
import java.io.*;

public class java_38867_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8181);
        while (true) {
            Socket socket = server.accept();
            new SecureServerThread(socket).start();
        }
    }
}

class SecureServerThread extends Thread {
    private Socket socket;
    public java_38867_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();

            // Checking if the client is trying to brute force the server.
            if (message.contains("brute force")) {
                out.writeUTF("Access Denied. Too many attempts.");
                out.flush();
                socket.close();
                return;
            }

            out.writeUTF("Message Received: " + message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}