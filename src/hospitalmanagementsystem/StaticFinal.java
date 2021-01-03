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

// Static ve Final örneğidir.
public class StaticFinal {

    public static int a = 0;//Static değişken örneğidir. Son aldığı değeri döndürür.
    public final int b = 5;//Final değişken örneğidir. Değeri değişmez.

    public static int cikarma(int a, int b) {//Static metot örneğidir.
        int sonuc = a - b;
        return sonuc;
    }
}