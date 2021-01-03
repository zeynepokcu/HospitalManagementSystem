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
/**
 * @param args the command line arguments
 */
class Hastane extends Inheritance {

    private final String hastaneTuru = "Özel Hastane";

    public static void main(String[] args) {

        // yeniHastane nesnesi oluştur.
        Hastane yeniHastane = new Hastane();

        // Inheritance sınıfından calistir() metodunu çağır.
        yeniHastane.calistir();

        System.out.println(yeniHastane.hastane + ": " + yeniHastane.hastaneTuru);

        // Durum ve Sonuc sınıflarından calistir() metotlarını çağır.
        Inheritance durum = new Durum();
        Inheritance sonuc = new Sonuc();

        durum.calistir();
        sonuc.calistir();
        
    }
}
