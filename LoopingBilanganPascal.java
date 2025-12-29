/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pengantar_pemrograman;

/**
 *
 * @author kensh
 */
import java.util.Scanner;
// Mengimpor class Scanner untuk membaca input dari keyboard

public class LoopingBilanganPascal {
    // Nama class utama (harus sama dengan nama file)
    public static void main (String[] args) {
        // Method utama yang akan dijalankan pertama kali
        
        Scanner input = new Scanner(System.in);
        // Membuat objek Scanner untuk membaca input pengguna
        
        System.out.print("===== Tambahkan Looping Index ===== ; ");
        // menampilkan pesan untuk meminta pengguna memasukkan jumlah baris segitiga Pascal
        int index = input.nextInt();
        // Membaca angka (jumlah baris) yang dimasukkan pengguna
        
        // Loop luar: mengatur jumlah baris segitiga Pascal
        for (int i =0; i < index; i++) {
            int nilai = 1;
            // Variabel untuk menyimpan nilai setiap elemen dalam baris Pascal
            
            // Loop dalam: mencetak nilai pada setiap kolom dalam baris ke-i
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // Elemen pertama dan terakhir dalam setiap baris Pascal selalu 1
                    nilai = 1;
                } else {
                    // Rumus kombinasi untuk menghitung nilai tengah segitiga Pascal
                    // nilai = nilai * (i - j + 1) / j
                    nilai = nilai * (i - j + 1) / j;
                }
                System.out.print(nilai + " ");
                // Menampilkan nilai di baris yang sama, di pisahkan oleh spasi
            }
            
            System.out.println();
            // Pindah ke baris berikutnya setelah satu baris selesai dicetak
        }
    }
}
            
          
        
        
    
    

