import java.io.*;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.lang.Math;

public class PowerOfTwo {
    public static void main(String[] args) {
        int i = 12;
        int j = 32;
        System.out.println(powerOfTwo(4));
        System.out.println(powerOfTwo(8));
    }
  

    public static boolean powerOfTwo(int i) {
        double d = Math.log10(i)/Math.log10(2); // log base 2 of i
        if (d % 1 == 0)
            return true;
        else
            return false; // fractional part exists
    }
}