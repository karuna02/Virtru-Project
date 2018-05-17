package resources;
import org.apache.commons.codec.binary.Base64;

public class EncryptPassword {
	
	public byte[] MailPassword()
	{
		String password = "xxxxxx";// Enter your Password
		
		byte[] encode = Base64.encodeBase64(password.getBytes());
		
		return encode;
	}	
	
}
