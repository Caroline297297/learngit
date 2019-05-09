import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

	public static void main(String[] args) {
		Socket socketAtClient;
        DataInputStream in = null;
        DataOutputStream out = null; 
        
        try
        {
        	//����Socket����
        	socketAtClient = new Socket("local", 5051);        	
        	
        	//�������롢���
        	in = new DataInputStream(socketAtClient.getInputStream());
        	out = new DataOutputStream(socketAtClient.getOutputStream());
        	
        	while(true)
        	{
        		int m = 0;
            	m = in.readInt();
            	
                out.writeInt(m*2);
                
                System.out.println("Server received: " + m);
                
                Thread.sleep(500);
        		
        	}
        }
        catch(IOException e)
        {
        	//�޷����ӿͻ���
        	System.out.println("connect error");
        }
        catch(InterruptedException e){}

	}

}
