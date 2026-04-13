import java.io.*;
import java.net.*;

public class java_02629_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        while (true) {
            Socket client = server.accept();
            new Handler(client).start();
        }
    }
}

class Handler extends Thread {
    private Socket sock;
    public java_02629_SocketServer_A03(Socket sock) { this.sock = sock; }
    public void run() {
        try {
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            DataInputStream dis = new DataInputStream(in);
            DataOutputStream dos = new DataOutputStream(out);

            String input = dis.readUTF();
            String output = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n\r\n" +
                    "<h1>" + escape(input) + "</h1>\r\n";

            dos.writeBytes("HTTP/1.1 200 OK\r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n\r\n");
            dos.writeBytes("<h1>" + escape(input) + "</h1>\r\n");
            dos.flush();

            sock.close();
        } catch (IOException e) { e.printStackTrace(); }
    }
    public static String escape(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}