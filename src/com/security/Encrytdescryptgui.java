/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


public class Encrytdescryptgui extends javax.swing.JFrame {
Cipher ecipher;
	Cipher dcipher;
   
    public Encrytdescryptgui() {
        initComponents();
    }
//USE "jcobobox.getselectedindex 
    public Encryptaldecryptal(SecretKey key, String algorithm) throws Exception 
    {
	   try
	   {
	       ecipher = Cipher.getInstance(algorithm);
	       dcipher = Cipher.getInstance(algorithm);
	       ecipher.init(Cipher.ENCRYPT_MODE, key);
	       dcipher.init(Cipher.DECRYPT_MODE, key);
	   }
	   catch (NoSuchAlgorithmException e)
	   {

	   }
       catch (InvalidKeyException e)
       {

       }
       catch (NoSuchPaddingException e)
       {

       }
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

	  }
	  catch (IllegalBlockSizeException e)
	  {

	  }
	  catch (UnsupportedEncodingException e)
	  {

	  }
	  catch (IOException e)
          {
              
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
               //JTEXTFIELD.TOSTRING
           return new String(utf8, "UTF8");
   }        catch (BadPaddingException e)
	     {

	     }
	    catch (IllegalBlockSizeException e)
	     {

	     }
	    catch (UnsupportedEncodingException e)
	     {

	     }
	    catch (IOException e)
            {
                
   }
    return null;

}

//The following method id used for encrypting and decrypting a 
//String using symmetric Secret key using "DES" algorithm
public static void useSecretKey()
{     Scanner input=new Scanner(System.in);
      System.out.println("Enter Text to be encripted Mr Kamal");
		//String stringToBeEncrypted = "String to be encrypted";
                String stringToBeEncrypted = input.nextLine();
                try
                {
		SecretKey desKey = KeyGenerator.getInstance("BlowFish").generateKey();
		Encryptaldecryptal encrypter = new Encryptaldecryptal(desKey, desKey.getAlgorithm());
                //Encrypt the String
		String encryptedString = encrypter.encrypt(stringToBeEncrypted);
                
        //Decrypt the String
        String decrypterString = encrypter.decrypt(encryptedString);
        //Display Values
        System.out.println("\tEncryption algorithm Name:" + desKey.getAlgorithm());
        System.out.println("\ttOriginal String : " + stringToBeEncrypted);
        System.out.println("\tEncrypted String : " + encryptedString);

        System.out.println("\tDecrypted String : " + decrypterString);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TEXTENCRYPTED");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DSA", "BlowFish", "RSA" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Encrytdescryptgui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
