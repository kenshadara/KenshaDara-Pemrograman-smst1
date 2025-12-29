/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pengantar_pemrograman;

/**
 *
 * @author kensh
 */
public class lab_3_Array {
public static void main(String[] args) {

        // Langkah 10: Membuat object array berisi karakter kalimat
        char[] kalimat = {
            'k','a','k','i','k','a','k','a','k','k','e','n','a','k','a','y','u','t','a',
            'k','b','e','r','p','a','k','u','k','a','k','u','k','a','k','u'
        };

        // Langkah 11: Menampilkan seluruh isi array
        System.out.print("Isi object array: ");
        for (char c : kalimat) {
            System.out.print(c);
        }

        // Garis pemisah
        System.out.println("\n-----------------------------");

        // Langkah 12: Menghitung jumlah huruf k
        int jumlahK = 0;
        for (char c : kalimat) {
            if (c == 'k') {
                jumlahK++;
            }
        }

        // Menampilkan hasil
        System.out.println("Jumlah huruf dalam array= " + kalimat.length);
        System.out.println("Jumlah huruf k dalam array= " + jumlahK);
    }
}
    
