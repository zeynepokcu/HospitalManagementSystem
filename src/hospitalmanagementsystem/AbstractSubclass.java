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

//Abstract alt sınıf örneğidir.
public class AbstractSubclass extends Abstract{

    @Override
    public int topla(int a, int b) {
        int sonuc=a+b;
        return sonuc;
    }
    
}
