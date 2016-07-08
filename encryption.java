package com.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.Scanner;

public class Encryptaldecryptal
{
	Cipher ecipher;
	Cipher dcipher;

	public Encryptaldecryptal(SecretKey key, String algorithm) throws Exception {
	   try
	   {
	       ecipher = Cipher.getInstance(algorithm);
	       dcipher = Cipher.getInstance(algorithm);
	       ecipher.init(Cipher.ENCRYPT_MODE, key);
	       dcipher.init(Cipher.DECRYPT_MODE, key);
	   }
	   catch (NoSuchAlgorithmException e)
	   {
System.out.println(e);
	   }
       catch (InvalidKeyException e)
       {
System.out.println(e);
       }
       catch (NoSuchPaddingException e)
       {
System.out.println(e);
       }
	}
        public static void main(String args[])
        {
            useSecretKey();
        }

	//Encode the string and returns an encrypted version
	//of that String.

	public String encrypt(String str)
	{
	  try
	  {
	     //Encode the string into bytes using utf-8
	     byte[] utf8 = str.getBytes("UTF8");

	     //Encrypt
	     byte[] enc = ecipher.doFinal(utf8);
	     //Encode bytes to base64 to get a string
	     return new sun.misc.BASE64Encoder().encode(enc);
	  }

	  catch (BadPaddingException e)
	  {
System.out.println(e);
	  }
	  catch (IllegalBlockSizeException e)
	  {
System.out.println(e);
	  }
	  catch (UnsupportedEncodingException e)
	  {
System.out.println(e);
	  }
	  catch (IOException e)
          {
            System.out.println(e);  
	}

	return null;
        
           
        }
        

	//decrypt() inputs a string and returns an encrypted version
//of that String.
                     public String decrypt(String str)

          {
   try
   {
   	    //Decode base64 to get bytes
   	       byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
   	   //Decrypt
   	       byte[] utf8 = dcipher.doFinal(dec);
   	   //Decode using utf-8
            
           return new String(utf8, "UTF8");
   }        catch (BadPaddingException e)
	     {
System.out.println("oops, looks like we've got a padding issue");
	     }
	    catch (IllegalBlockSizeException e)
	     {
System.out.println("Error, error: Block size is quite abnormal");
	     }
	    catch (UnsupportedEncodingException e)
	     {
System.out.println("oops,looks like the encoding method doesn't exixts, try again ");
	     }
	    catch (IOException e)
            {
                
   }
  
    return null;

}

//The following method is used for encrypting and decrypting a 
//String using symmetric Secret key using "blowfish" algorithm but can be alternated with algorithm of choice
public static void useSecretKey()
{     Scanner input=new Scanner(System.in);
      System.out.println("Enter Text to be encrypted");
		System.out.println("it can be anything");
                String stringToBeEncrypted = input.nextLine();
                try
                {
		SecretKey desKey = KeyGenerator.getInstance("BlowFish").generateKey();
                //You can substitute Blowfish with any encryption technique you prefer e.g DES, AES, etc
		Encryptaldecryptal encrypter = new Encryptaldecryptal(desKey, desKey.getAlgorithm());
                //Encrypt the String
		String encryptedString = encrypter.encrypt(stringToBeEncrypted);
                
        //Decrypt the String
        String decrypterString = encrypter.decrypt(encryptedString);
        //Displays the Values
        System.out.println("\tEncryption algorithm Name:" + desKey.getAlgorithm());
        System.out.println("\ttOriginal String : " + stringToBeEncrypted);
        System.out.println("\tEncrypted String : " + encryptedString);

        System.out.println("\tDecrypted String : " + decrypterString);
                }
                catch(Exception e)
                {
                    System.out.println(e)
					System.out.println(e);
					
                }
           //Endline     
}

       
	

 
}
