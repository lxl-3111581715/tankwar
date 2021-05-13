package test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ImageTest {
    @Test
    public void test() {
//测试将一张图片从硬盘中拿到内存中读取
//        try {
//            BufferedImage image =ImageIO.read(new File("D:/desktop/Java基础/tankwrgit/tankwar01/src/image/tank1.jpeg"));
////            断言 ： 判断条件 成立 通过 不成立  不通过
//            assertNotNull(image); c src\image\tank1.jpeg
//        System.out.println("======>"+new File("D:/desktop/Java基础/tankwrgit/tankwar01/src/image/tank1.jpeg"));
        System.out.println("=====>+" + ImageTest.class);
        System.out.println("=====>+" + ImageTest.class.getClassLoader());
        System.out.println("=====>+" + ImageTest.class.getClassLoader().getResourceAsStream("D:/desktop/Java基础/tankwrgit/tankwar01/src/image/tank1.jpeg"));
//            System.out.println("+++++++>"+ImageTest.class.getClassLoader().getResourceAsStream("image/tank1.jpeg"));
//            BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("D:/desktop/Java基础/tankwrgit/tankwar01/src/image/tank1.jpeg"));
//            assertNotNull(image1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test1() {
        BufferedImage image = null;
        try {
//            image = ImageIO.read(new File("D:/desktop/Java基础/tankwrgit/tankwar01/src/image/tank1.jpeg"));
            image = ImageIO.read(new File("image/tank1.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//            断言 ： 判断条件 成立 通过 不成立  不通过
        assertNotNull(image);
    }

    @Test
    public void test3() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("image/tank1.jpeg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
//            断言 ： 判断条件 成立 通过 不成立  不通过
        assertNotNull(image);
    }
}
