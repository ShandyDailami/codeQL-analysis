import java.io.*;
import java.net.*;

public class java_10556_SocketServer_A01 {

    public static void main(String[] args) {

        int port = 8080; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Echo: " + message);
                out.flush();

                socket.close();
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}