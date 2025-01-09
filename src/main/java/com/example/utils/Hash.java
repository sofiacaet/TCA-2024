package com.example.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash 
{

    public static void main(String[] args) 
    {
        String originalString = "senha123";
        String hashedString = generateHash(originalString, "SHA-256");

        System.out.println("Original: " + originalString);
        System.out.println("Hash: " + hashedString);
    }

    public static String generateHash(String input, String algorithm) 
    {
        try {
            // Inicializa o MessageDigest com o algoritmo especificado
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            
            // Calcula o hash da entrada
            byte[] hashBytes = messageDigest.digest(input.getBytes());
            
            // Converte o hash em uma string hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao calcular hash: Algoritmo não encontrado", e);
        }
    }

    public static boolean verificarSenha(String senha, String hashArmazenado) {
        try {
            String hashSenhaFornecida = Hash.generateHash(senha, "SHA-256");
            return hashSenhaFornecida.equals(hashArmazenado);  // Compara os hashes
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}