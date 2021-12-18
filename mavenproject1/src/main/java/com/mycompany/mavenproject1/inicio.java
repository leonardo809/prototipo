/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.firebase.conectar;

/**
 *
 * @author leonardo
 */
public class inicio {
    public static void main(String[] args){
try{
conectar();

InicioSesion ini=new InicioSesion();
ini.setVisible(true);


ini.setVisible(true);
}catch(Exception e){
System.out.print(e);
}
}
}
