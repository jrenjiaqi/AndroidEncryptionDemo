package com.example.encryptiondecryptiondemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.encryptiondecryptiondemo.encryptionutils.AESGenerator;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class TwoWayEncryption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way_encryption);

        // initialise SecretKey, IvParameterSpec, and algorithm for encrypt and decrypt.
        SecretKey key = null;
        try {
            key = AESGenerator.generateKey(128);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        IvParameterSpec ivParameterSpec = AESGenerator.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";

        // onclick listener for encrypt button (encrypts input text and displays in textview).
        Button encryptTextButton = (Button) findViewById(R.id.EncryptTextBtn);
        SecretKey finalKeyEncrypt = key;
        encryptTextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View v) {
                String inputText = ((EditText)findViewById(R.id.EnterTextEditText))
                        .getText().toString();

                String cipherText = "error";
                try {
                    cipherText = AESGenerator.encrypt(algorithm, inputText, finalKeyEncrypt, ivParameterSpec);
                } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException
                        | NoSuchPaddingException | IllegalBlockSizeException
                        | BadPaddingException | InvalidKeyException e) {
                    e.printStackTrace();
                }

                TextView encryptedTextView = (TextView)findViewById(R.id.EncryptedResultTextView);
                encryptedTextView.setText(cipherText);
            }
        });

        // onclick listener for decrypt button (decrypts encrypted text and displays in textview).
        Button decryptTextButton = (Button) findViewById(R.id.DecryptTextBtn);
        SecretKey finalKeyDecrypt = key;
        decryptTextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void onClick(View v) {
                TextView encryptedTextView = (TextView)findViewById(R.id.EncryptedResultTextView);
                String encryptedText = encryptedTextView.getText().toString();

                String decipheredCipherText = "error";
                try {
                    decipheredCipherText = AESGenerator.decrypt(algorithm, encryptedText,
                                                                        finalKeyDecrypt, ivParameterSpec);
                } catch (NoSuchPaddingException | NoSuchAlgorithmException
                        | InvalidAlgorithmParameterException | InvalidKeyException
                        | BadPaddingException | IllegalBlockSizeException e) {
                    e.printStackTrace();
                }

                TextView decryptedTextView = (TextView)findViewById(R.id.DecryptedResultTextView);
                decryptedTextView.setText(decipheredCipherText);
            }
        });
    }
}