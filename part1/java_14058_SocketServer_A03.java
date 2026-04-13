import java.io.*;
import java.net.*;

public class java_14058_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
       
            System.exit(-1);
        }

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Received request: " + request);

                if (request.equals("QUIT")) {
                    dos.writeUTF("Goodbye!");
                    dos.close();
                    socket.close();
                    System.out.println("Client disconnected");
                    break;
                }
                else {
                    dos.writeUTF("Hello " + request + "! How are you today?");
                    dos.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client disconnected");
            }
        }
        server.close();
    }
}