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

//Abstract sınıf örneğidir. (Example for abstract class)
public abstract class Abstract {

    public abstract int topla(int a, int b);

    public double bolme(int a, int b) {
        double sonuc = a / b;
        System.out.println("Sonuç: " + sonuc);
        return sonuc;
    }
}
