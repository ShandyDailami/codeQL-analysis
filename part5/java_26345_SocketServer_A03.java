import java.io.*;
import java.net.*;

public class java_26345_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage: SocketServer <port> <password>");
                return;
            }

            int port = Integer.parseInt(args[0]);
            String password = args[1];

            if (!password.equals("secret")) {
                System.out.println("Invalid password");
                return;
            }

            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Hello, client!");
                out.flush();
                System.out.println("Sent: " + "Hello, client!");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}