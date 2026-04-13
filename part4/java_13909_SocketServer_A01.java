import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13909_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket client = server.accept();
            OutputStream out = client.getOutputStream();
            out.write("HTTP/1.1 200 OK\n".getBytes());
            out.write("Content-Type: text/html\n\n".getBytes());
            out.write("<h1>Hello World!</h1>\n".getBytes());
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null && inputLine.length() > 0) {
                System.out.println(inputLine);
            }
            client.close();
        }
    }
}