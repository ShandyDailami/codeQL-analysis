import java.io.*;
import java.net.*;

public class java_13482_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server started on port 6000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Request: " + request);

                // Perform some security-sensitive operations related to A07_AuthFailure
                if (request.equals("auth")) {
                    out.writeUTF("success");
                } else {
                    out.writeUTF("failure");
                }
                out.flush();

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}