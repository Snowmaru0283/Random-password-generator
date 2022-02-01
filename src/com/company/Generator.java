package com.company;

import java.util.Random;


public class Generator {

    private int length;
    private char[] password;
    private String numbers = "0123456789";
    private String letters = "ABCDEFGHILMNOQRSTUVWXYZ";
    private String specialCharacters = "!#@$%&£?";
    private Random rndm = new Random();


    public Generator(int initialLength) {
        this.length = initialLength;
        this.password = new char[initialLength];
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPassword (int length){
        this.password = new char[length];
    }

    public void shufflePassword() {
        char[] temp = new char[length];
        System.arraycopy (password, 0, temp, 0 , length);
        int i = 0;
        while (i < length){
            int randomIndex = generateRandomIndex();
            if (temp[randomIndex] != ' '){
                password[i] = temp[randomIndex];
                temp[randomIndex] = ' ';
                i++;
            }
        }
    }
    public String passwordInString() {
        String password = new String(this.password);
        return password;
    }

    private int generateRandomIndex (){
        return rndm.nextInt(password.length);
    }

    private void resetArrayValues (){
        for (int i = 0; i < length; i++){
            password[i] = 0;
        }
    }

    public String generateRandomPin (){
        for (int i = 0; i < password.length; i++){
            password[i] = numbers.charAt(rndm.nextInt(numbers.length()));
        }
        return passwordInString();
    }

    public String generatePasswordAlph(){
        for (int i = 0; i < password.length; i++){
            password[i] = letters.charAt(rndm.nextInt(letters.length()));
        }
        return passwordInString();
    }


    public String generateRandPasswordChar () {
        int i = 0;
        resetArrayValues();
        while (i < password.length) {
            int randomIndex1 = generateRandomIndex();
            if (password[randomIndex1] == 0) {
                password[randomIndex1] = letters.charAt(rndm.nextInt(letters.length()));
                i++;
            }
            int randomIndex2 = generateRandomIndex();
            if (randomIndex2 != randomIndex1 && password[randomIndex2] == 0) {
                password[randomIndex2] = numbers.charAt(rndm.nextInt(numbers.length()));
                i++;
            }
            int randomIndex3 = generateRandomIndex();
            if (randomIndex3 != randomIndex1 && randomIndex3 != randomIndex2 && password[randomIndex3] == 0){
                password[randomIndex3] = specialCharacters.charAt(rndm.nextInt(specialCharacters.length()));
                i++;
            }
        }
        shufflePassword();
        return passwordInString();
    }

    public String shuffleInputPassword (String inputPassword){
        char[] temp = new char [inputPassword.length()];
        for (int i = 0; i < inputPassword.length(); i++){
            temp[i] = inputPassword.charAt(i);
        }
        char[] newInputPassword = new char[inputPassword.length()];
        int i = 0;
        while (i < inputPassword.length()){
            int randomIndex = rndm.nextInt(inputPassword.length());
            if (temp[randomIndex] != ' '){
                newInputPassword[i] = temp[randomIndex];
                temp[randomIndex] = ' ';
                i++;
            }
        }
        String password = new String(newInputPassword);
        return password;
    }

}
