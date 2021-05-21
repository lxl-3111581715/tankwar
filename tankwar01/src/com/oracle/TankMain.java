package com.oracle;

public class TankMain {
    public static void main(String[] args) throws InterruptedException {
        TankFrame2 frame2 = new TankFrame2();
        // 初始化地方坦克
        for(int i = 0;i<5 ;i++){
            frame2.tanks.add(new Tank(50 + i*100,200,Dir.DOWN,Group.BAD,frame2));
        }
//
        while (true) {
            Thread.sleep(50);
            frame2.repaint();
        }
    }
}
