import java.net.*;
import java.io.*;
import java.util.*;

public class java_09508_SocketServer_A07 {
    private static final String EXPECTED_PASSWORD = "A07_AuthFailure";
    private static final String SERVER_PASSWORD = "server";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6543);
            while (true) {
                Socket socket = serverSocket.accept();
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String password = dis.readUTF();
            if (password.equals(EXPECTED_PASSWORD)) {
                dos.writeUTF(SERVER_PASSWORD);
                dos.flush();
            } else {
                dos.writeUTF("AuthFailure");
                dos.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}