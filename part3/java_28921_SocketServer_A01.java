import java.io.*;
import java.net.*;

public class java_28921_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Connection from " + socket.getRemoteSocketAddress());
                
                //Create new threads for handling each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_28921_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            OutputStream out = new BufferedOutputStream(socket.getOutputStream());
            InputStream in = new BufferedInputStream(socket.getInputStream());
            
            // Create a new dataInputStream and dataOutputStream
            DataInputStream dataIn = new DataInputStream(in);
            DataOutputStream dataOut = new DataOutputStream(out);
            
            // Read the message from the client
            String message = dataIn.readUTF();
            System.out.println("Received: " + message);
            
            // Reply to the client
            String response = "Server says: " + message;
            dataOut.writeUTF(response);
            dataOut.flush();
            
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}