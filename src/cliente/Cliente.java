package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("10.113.1.180"), 3311);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String out;
        
        while ( (out = reader.readLine()) != null ){            
                writer.write(String.format("%s\n", out));
                writer.flush();   
            if (out.equalsIgnoreCase("sair")){
                break;
            } 
        }               
        writer.close();
        reader.close();
        socket.close(); 
    }
    
}
