package com.androidand.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(fibonnacci(10));
        TextView textView2 = (TextView) findViewById(R.id.text2);
        if (checkBrackets("(())")) {textView2.setText("true");} else {textView2.setText("false");}
        TextView textView3 = (TextView) findViewById(R.id.text3);
        textView3.setText(checkCheck("salut les loulous"));
        Intervalle i1= new Intervalle(0,10);
        Log.e("test1","i1="+i1);
    }
    public String reve(String mot) {
        String motRetourne;
        StringBuffer motBuffer = new StringBuffer(mot);
        motRetourne = motBuffer.reverse().toString();
        return motRetourne;
    }
    public Boolean isPalimdrome(String mot) {
        Boolean result = true;
        int size = mot.length();
        for (int i = 0; i < size / 2; i++) {
            if (mot.charAt(i) != mot.charAt(size - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }
    public String spaceDestroyer1(String toDestroy) {

        String sentence;
        StringBuffer motBuffer = new StringBuffer(toDestroy);

        while (motBuffer.charAt(0) == ' ') {
            motBuffer.deleteCharAt(0);
        }
        while (motBuffer.charAt(motBuffer.length() - 1) == ' ') {
            motBuffer.deleteCharAt(motBuffer.length() - 1);
        }
        return rewritte2(motBuffer.toString());
    }
    public String rewritte2(String sentence) {
        String string = sentence.replaceAll("\\s+", " ");
        return string;
    }
    public boolean checkBrackets(String bracketsString) {
//        ouvrante :+1 fermante:-1

        StringBuffer buffer = new StringBuffer(bracketsString);
        double counter = 0;
        int size = buffer.length();
        for (int i = 0; i < size - 1; i++) {
            if (buffer.charAt(i) == '(') {
                counter = counter + 1;
            }
            if (buffer.charAt(i) == ')') {
                counter = counter - 1;
            }
        }
        if (counter != 0) {
            return false;
        } else {
            return true;
        }

    }
    public String checkCheck(String sentence) {

        StringBuffer buffer = new StringBuffer(sentence);
        StringBuffer newBuffer = new StringBuffer();
        StringBuffer littleBuffer = new StringBuffer();
        int size = buffer.length();
        for (int i = 0; i < size - 1; i++) {

            littleBuffer.append(buffer.charAt(i));
            if (buffer.charAt(i) == ' ') {
                newBuffer.append(randomLetters(littleBuffer.toString()));
                newBuffer.append(' ');
                littleBuffer.delete(0, littleBuffer.length() - 1);
            }
        }
        return newBuffer.toString();
    }
    public String randomLetters(String word) {
        int size = word.length();
        StringBuffer wordBuffer = new StringBuffer(word);
        StringBuffer newBuffer = new StringBuffer(size);
      for(int j=0; j<size; j++){

            Random randomno = new Random();
            int position = randomno.nextInt(size-j);
            newBuffer.append(wordBuffer.charAt(position));
            wordBuffer.deleteCharAt(position);
            size = wordBuffer.length();
        }
        return newBuffer.toString();
    }
    public String fibonnacci(int n){

        StringBuffer buffer = new StringBuffer();
        int number1=0;
        int number2=1 ;
        int newNumber;
        buffer.append(String.valueOf(number1));
        buffer.append(String.valueOf(number2));
        for(int i=2; i<n; i++){
            newNumber= number1+number2;
            buffer.append(String.valueOf(newNumber));
            number1=number2;
            number2=newNumber;
        }
        return buffer.toString();
    }
    public void mapBlindTest(){
        Map<String,String> map = new HashMap<>();
    }

}
