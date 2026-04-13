import java.io.*;
import java.net.*;

public class java_26624_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("exit")) {
                    break;
                }

                out.writeUTF("Message received.");
                out.flush();
                System.out.println("Sent: Message received.");
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}