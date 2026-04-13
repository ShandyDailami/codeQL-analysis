import java.io.*;
import java.net.*;

public class java_04640_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening at port 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Client says: " + request);

                String response = processRequest(request);

                dos.writeUTF(response);
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // Add some security-sensitive operations related to A03_Injection here
        // For now, just return the same request
        return request;
    }
}