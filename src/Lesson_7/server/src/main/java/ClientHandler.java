import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private server server;
    private Socket socket;

    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(()-> {
                try {
                    while (true) {
                        String clientMessage = in.readUTF();
                        if (clientMessage.equals("/end")) {
                            System.out.println("Client disconnected" + socket.getRemoteSocketAddress());
                            break;
                        }
                        server.broadCastMessage("Echo: " + socket.getRemoteSocketAddress() + ": " + clientMessage);
//                        out.writeUTF("Echo: " + socket.getRemoteSocketAddress() + ":" + clientMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
