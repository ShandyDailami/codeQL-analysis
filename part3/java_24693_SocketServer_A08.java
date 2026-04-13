import java.io.*;
import java.net.*;

public class java_24693_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String fileName = in.readUTF();
            File file = new File(fileName);

            if (file.exists()) {
                out.writeUTF("File Found!");
                out.writeLong(file.length());

                byte[] buffer = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(buffer);
                fis.close();

                out.write(buffer);
                out.flush();
            } else {
                out.writeUTF("File Not Found!");
            }

            socket.close();
        }
    }
}