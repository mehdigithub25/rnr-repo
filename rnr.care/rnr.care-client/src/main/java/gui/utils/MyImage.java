/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.utils;

import javafx.scene.image.Image;

/**
 *
 * @author azmi.ghis
 */
public class MyImage {
    public static Image fromResources(String name){
        Image i = new Image(MyImage.class.getResourceAsStream("/pics/"+name));
        return i;
    }
}
