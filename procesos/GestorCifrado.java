package procesos;

import java.security.*; /** * Clase con métodos estáticos de cifrado * */ 

public class GestorCifrado { 
	public static String getEncoded(String text, String algorithm) throws NoSuchAlgorithmException { 
			String output; //texto de salida = texto de entrada codificado 
			MessageDigest md; 
			byte[] textBytes = text.getBytes(); //raw-bytes del texto de entrada 
			md = MessageDigest.getInstance(algorithm); //método factoría 
			md.update(textBytes); //actualización  
			byte[] outputBytes = md.digest(); 
			output = new String(outputBytes); 
			return output; 
		} 
	
	public static String getEncoded(String text) throws NoSuchAlgorithmException { 
			return getEncoded(text, "MD5"); 
		} 
	}

