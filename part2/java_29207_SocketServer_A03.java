import java.io.*;
import java.net.*;

public class java_29207_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(55555);
            while (true) {
                Socket socket = server.accept();
                new HandleConnection(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleConnection extends Thread {
    Socket socket;

    public java_29207_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.writeBytes("Message received\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}