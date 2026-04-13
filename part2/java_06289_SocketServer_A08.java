import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.nio.file.Files;

public class java_06289_SocketServer_A08 {

    private static final int PORT = 6000;
    private static final String ROOT = "./";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String fileName = dis.readUTF();
            File file = new File(ROOT + fileName);

            if (file.exists()) {
                dos.writeUTF("File Found!");
                sendFile(new FileInputStream(file), dos);
            } else {
                dos.writeUTF("File not Found!");
            }

            socket.close();
        }
    }

    private static void sendFile(FileInputStream fis, DataOutputStream dos) throws IOException {
        byte[] buffer = new byte[4 * 1024];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, bytesRead);
        }
    }
}