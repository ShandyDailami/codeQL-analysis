import java.io.*;
import java.net.*;

public class java_40720_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                if (request.equals("auth")) {
                    out.writeUTF("Success");
                } else {
                    out.writeUTF("Failure");
                }
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}