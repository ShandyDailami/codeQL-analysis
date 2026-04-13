import java.io.*;
import java.net.*;

public class java_28202_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the file name
            String fileName = dis.readUTF();
            System.out.println("File name received: " + fileName);

            // Handling files that are not present or not accessible
            File file = new File(fileName);
            if (!file.exists()) {
                dos.writeUTF("404 Not Found");
                dos.close();
                socket.close();
                System.out.println("File not found!");
                continue;
            }

            // Sending the file to the client
            dos.writeUTF("200 OK");
            dos.writeLong(file.length());
            dos.writeUTF("octet-stream");

            FileInputStream fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                dos.writeByte(content);
            }
            fis.close();
            dos.close();
            socket.close();
        }
    }
}