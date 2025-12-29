/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlatMusik;

/**
 *
 * @author kensh
 */
public class MainProgram {
    public static void main(String[] args) {

        AlatMusik[] musik = {
            new Piano(),
            new Biola(),
            new Gitar(),
            new Drum(),
            new Saxophone(),
            new Trumpet()
        };

        System.out.println("=== Contoh Polimorfisme Alat Musik ===");
        for (AlatMusik m : musik) {
            m.bunyi();     // pemanggilan metode dengan polimorfisme
        }
    }
}

