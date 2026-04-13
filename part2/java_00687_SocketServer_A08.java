import java.io.*;
import java.net.*;

public class java_00687_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Print message to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Connected to the server!");

            // Send file to the client
            File file = new File("path_to_file");
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            fileInputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}