/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Seth
 */
public class CustomMath {

    public int ceiling(int x, int y) {
        int z = x / y + ((x % y == 0) ? 0 : 1) + 1;
        return z;
    }
}
