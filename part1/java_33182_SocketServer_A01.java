import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class java_33182_SocketServer_A01 {
    private ServerSocket server;

    public java_33182_SocketServer_A01(int port) throws IOException {
        server = new ServerSocket(port);
        server.setReuseAddress(true);
    }

    public void handleClient(Socket client) {
        try {
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            Scanner scanner = new Scanner(input);
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("Hello, client!");
            writer.flush();

            String response = scanner.nextLine();
            writer.println(response);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket client = server.accept();
                handleClient(client);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SecureServer(8080).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}