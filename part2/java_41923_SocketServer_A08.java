import java.io.*;
import java.net.*;

public class java_41923_SocketServer_A08 {
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

                if (request.equals("fail")) {
                    out.writeUTF("IntegrityFailure");
                } else {
                    out.writeUTF("Success");
                }

                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}