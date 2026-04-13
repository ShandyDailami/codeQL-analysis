import java.io.*;
import java.net.*;

public class java_07022_SocketServer_A08 {
    private static final String HOST = "localhost";
    private static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Perform integrity check
                boolean integrityCheck = performIntegrityCheck(in);

                if (integrityCheck) {
                    out.writeUTF("Successful integrity check!");
                    System.out.println("Successful integrity check!");
                } else {
                    out.writeUTF("Integrity check failed!");
                    System.out.println("Integrity check failed!");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean performIntegrityCheck(DataInputStream in) {
        // Simulate a check by reading the next byte
        try {
            in.readByte();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}