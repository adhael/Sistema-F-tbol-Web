/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolweb.email;

/**
 *
 * @author Felipe
 */
public class TestEmail {
    
    public static void main(String[] args){
        
    Email e = new Email("Prueba de sistema", "Este es una prueba de Sistema By Adhael Rodriguez", "clsuesca4@misena.edu.co");
    e.enviarEmail();
    
    }
}
