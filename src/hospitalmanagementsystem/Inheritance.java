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
class Inheritance {

    String hastane = "Okcu Hastanesi";

    public void calistir() {
        System.out.println("Sistem çalıştırılıyor.");
    }
}

// Polymorphism örneğidir.
class Durum extends Inheritance {

    @Override
    public void calistir() {
        System.out.println("Sistem uygun.");
    }
}

class Sonuc extends Inheritance {

    @Override
    public void calistir() {
        System.out.println("Sistemi kullanabilirsiniz.");
    }
}
