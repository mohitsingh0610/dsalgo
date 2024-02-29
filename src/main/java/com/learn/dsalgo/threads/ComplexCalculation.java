package com.learn.dsalgo.threads;

import java.math.BigInteger;

public class ComplexCalculation {

    public static void main(String[] args) {
        System.out.println(calculateResult(BigInteger.valueOf(2),BigInteger.valueOf(2),BigInteger.valueOf(2),BigInteger.valueOf(2)));
    }

    public static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2){
        BigInteger result = BigInteger.ZERO;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        
        thread1.start();
        thread2.start();
        try{
        thread1.join();
        thread2.join();  
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        result = thread1.getResult().add(thread2.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
        while (power.compareTo(BigInteger.ZERO) != 0) {
            this.result = this.result.multiply(base);
            power = power.subtract(BigInteger.ONE);
           }    
        }
    
        public BigInteger getResult() { return result; }
    }

}
