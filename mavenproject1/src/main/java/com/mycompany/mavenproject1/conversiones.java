/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import static java.lang.Double.parseDouble;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;  
import java.time.Period;
import javax.swing.JOptionPane;
/**
 *
 * @author leonardo
 */
public class conversiones {
    public String altura(String altura){
return Double.toString(parseDouble(altura)/100);
}
public String edad(String fecha){
Period edad = Period.between(LocalDate.of(Integer.parseInt(fecha.substring(0,4)),Integer.parseInt(fecha.substring(5, 7)), Integer.parseInt(fecha.substring(8, 10))), LocalDate.now());
return Integer.toString(edad.getYears());    
}

}
