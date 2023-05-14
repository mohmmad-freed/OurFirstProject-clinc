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
            ((ADMIN_SCREEN) frameToOpen).startS();
        }
        else if(frameToOpen instanceof ADDD_SCREEN){}
        else if(frameToOpen instanceof DELD_SCREEN){
        ((DELD_SCREEN) frameToOpen).start();
        }
        else if(frameToOpen instanceof SECRETARY_SCREEN){
            ((SECRETARY_SCREEN)frameToOpen).start();
        }
        else if(frameToOpen instanceof DOCTOR_SCREEN){
        ((DOCTOR_SCREEN) frameToOpen).start();
        }
        else if(frameToOpen instanceof LOGIN_SCREEN){}
        else if (frameToOpen instanceof OLD_PATIENT_SCREEN){
        ((OLD_PATIENT_SCREEN) frameToOpen).start();
        
        }
        else if (frameToOpen instanceof NEW_PATIENT_SCREEN){
        ((NEW_PATIENT_SCREEN)frameToOpen).start();}
    }
    
}
