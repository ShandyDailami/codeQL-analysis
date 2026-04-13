import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12874_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            new HandleClient(input, output).start();
        }
    }
}

class HandleClient extends Thread {
    private DataInputStream input;
    private DataOutputStream output;

    public java_12874_SocketServer_A08(DataInputStream input, DataOutputStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = input.readUTF()) != null) {
                System.out.println("Received: " + message);
                // Here you could implement some security-sensitive operations
                // For example, by checking the message's content and rejecting it if it contains a certain pattern
                // However, in this case, we're not implementing any security-sensitive operations
                output.writeUTF("Message received");
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}