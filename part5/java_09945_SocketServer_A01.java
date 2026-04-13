import java.io.*;
import java.net.*;

public class java_09945_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            File file = new File("./example.txt");
            FileInputStream fis = new FileInputStream(file);
            out.writeUTF("Server ready");
            int bytesRead;
            byte[] bytes = new byte[1024];
            while ((bytesRead = fis.read(bytes)) != -1) {
                out.write(bytes, 0, bytesRead);
            }
            fis.close();
            out.close();
            socket.close();
       
        }
    }
}