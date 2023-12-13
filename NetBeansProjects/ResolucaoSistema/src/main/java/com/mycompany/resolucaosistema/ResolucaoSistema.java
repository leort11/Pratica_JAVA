package com.mycompany.resolucaosistema;

import java.awt.Toolkit;
import java.awt.Dimension;

public class ResolucaoSistema {

    public static void main(String[] args) {
        Toolkit toll = Toolkit.getDefaultToolkit();
        Dimension resol = toll.getScreenSize();
        
        System.out.println("A resolução da sua tela é: " + resol.width + "x" + resol.height);
    }
}
