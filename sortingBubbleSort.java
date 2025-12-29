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
 
public class sortingBubbleSort {
 
    public static void main(String[] args) {
 
        Scanner input = new Scanner(System.in);
 
        System.out.print("Masukkan jumlah elemen array: ");
        int n = input.nextInt();
 
        int[] data = new int[n];
 
        System.out.println("Masukkan elemen-elemen array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke-" + (i + 1) + ": ");
            data[i] = input.nextInt();
        }
 
        System.out.println("\nData sebelum diurutkan:");
        tampilkanArray(data);
 
        bubbleSort(data);
 
        System.out.println("\nData setelah diurutkan (Ascending):");
        tampilkanArray(data);
    }
 
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
 
        // Proses Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
 
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tukar elemen
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // Jika tidak ada pertukaran, array sudah urut
            if (!swapped) break;
        }
    }
 
    public static void tampilkanArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

