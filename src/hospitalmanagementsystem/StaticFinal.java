/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagementsystem;

/**
 *
 * @author Zeynep
 */

// Static ve Final örneğidir. (Example for Static and Final)
public class StaticFinal {

    public static int a = 0;//static değişken örneğidir. son aldığı değeri döndürür.
    public final int b = 5;//final değişken örneğidir. değeri değişmez.

    public static int cikarma(int a, int b) {//static metot örneğidir.
        int sonuc = a - b;
        return sonuc;
    }
}
