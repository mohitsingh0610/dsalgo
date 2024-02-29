package com.learn.dsalgo.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VaultHacker {

     public static final int MAX_PWD  = 100;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PWD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());
        for( Thread thread: threads){
            thread.start();
        }
    }

    private static class Vault {

       private int password;

       public Vault(int password){
        this.password = password;
       }

       public boolean isPasswordCorrect(int guess){
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            return guess == this.password;
       }
       
    }

    private static  abstract class HackerThread extends Thread {

        protected Vault vault;

        public HackerThread(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getName());
            this.setPriority(MAX_PRIORITY);
        }

        @Override
        public void start(){
          System.out.println("Starting thread " + this.getName());
          super.start();
        }
    }


    private static class AscendingHackerThread extends HackerThread{

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
             for(int guess=0; guess< MAX_PWD; guess++){
                if(vault.isPasswordCorrect(guess)){
                    System.out.println(this.getName()+ " hacked the vault and pwd is " + guess);
                    System.exit(0);
                }
             }
        }
        
    }

    private static class DescendingHackerThread extends HackerThread{

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run(){
             for(int guess=MAX_PWD; guess> 0; guess--){
                if(vault.isPasswordCorrect(guess)){
                    System.out.println(this.getName()+ "hacked the vault and pwd is " + guess);
                    System.exit(0);
                }
             }
        }
        
    }

    private static class PoliceThread extends Thread{

        public PoliceThread(){
            this.setName(this.getClass().getName());
        }

        @Override
        public void run() {
             for(int i=10; i>0 ; i--){
                  try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
             }
             System.out.println("Game over hackers");
             System.exit(0);
        }
    }
}
