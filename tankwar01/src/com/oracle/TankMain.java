package com.oracle;

public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        TankFrame2 frame2 = new TankFrame2();
        while (true) {
            Thread.sleep(50);
            frame2.repaint();
        }
    }
}
