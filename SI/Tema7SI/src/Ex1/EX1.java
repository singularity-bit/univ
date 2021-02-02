package Ex1;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.rmi.CORBA.Util;

public class EX1 {
	public Key keyGeneration(String pasw) throws NoSuchAlgorithmException, InvalidKeySpecException {
		char[] password=pasw.toCharArray();
		byte[] salt=new byte[16];
		int iteration_cnt=1000;
		int key_size=128;
		SecureRandom myPRNG=new SecureRandom();
		myPRNG.nextBytes(salt);
		SecretKeyFactory keyFactory=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec pbekSpec=new PBEKeySpec(password,salt,iteration_cnt,key_size);
		SecretKey myAESPBKey=new SecretKeySpec(keyFactory.generateSecret(pbekSpec).getEncoded(), "AES");
		return myAESPBKey;
	}
public String encrypt(Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
	
	Cipher myAES=Cipher.getInstance("AES/CBC/NoPadding");
	myAES.init(Cipher.ENCRYPT_MODE, key);
	byte[] plaintext=new byte[16];
	byte[]ciphertext=new byte[16];
	int cLength=myAES.update(plaintext, 0,plaintext.length,ciphertext,0);
	cLength+=myAES.doFinal(ciphertext, cLength);
	System.out.println("plaintext: "+javax.xml.bind.DatatypeConverter.printHexBinary(plaintext));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
