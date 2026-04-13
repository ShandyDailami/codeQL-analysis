import java.io.*;
import java.net.*;
import java.util.*;

public class java_41598_SocketServer_A01 {

    private static String publicDirectory = "public";
    private static String html = "<html><body><h1>Hello, World!</h1></body></html>";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + html.length() + "\r\n" +
                    "\r\n" +
                    html + "\r\n");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String request = in.readUTF();

            System.out.println("Request: " + request);

            File file = new File(publicDirectory, in.readUTF());
            DataInputStream fileIn = new DataInputStream(new FileInputStream(file));

            byte[] buffer = new byte[4096];
            int bytes = fileIn.read(buffer);

            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            outToClient.writeUTF("HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + file.length() + "\r\n" +
                    "\r\n");

            outToClient.write(buffer, 0, bytes);
            outToClient.flush();

            fileIn.close();
            socket.close();
        }
    }
}