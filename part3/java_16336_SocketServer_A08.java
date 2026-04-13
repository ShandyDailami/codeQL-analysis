import java.io.*;
import java.net.*;

public class java_16336_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket client = server.accept();
            new Handler(client).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_16336_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                if (message.equals("close")) {
                    socket.close();
                    return;
                }
                System.out.println("Received: " + message);
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}