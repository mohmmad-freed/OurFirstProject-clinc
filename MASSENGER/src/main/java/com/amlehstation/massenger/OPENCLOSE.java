/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amlehstation.massenger;

import javax.swing.JFrame;

/**
 *
 * @author ASD
 */
public class OPENCLOSE {
    public static void closeAndOpen(JFrame frameToClose, JFrame frameToOpen) {
        frameToClose.dispose();
        frameToOpen.setVisible(true);
        frameToOpen.setExtendedState(JFrame.MAXIMIZED_BOTH);
        if(frameToOpen instanceof ADMIN_SCREEN) {
            ((ADMIN_SCREEN) frameToOpen).start();
        }
        else if(frameToOpen instanceof ADMIN_SCREEN){}
    }
    
}
