package com.mycompany.idiomasistema;

import java.util.Locale;

public class IdiomaSistema {

    public static void main(String[] args) {
        Locale idioma =  Locale.getDefault();
        System.out.print("O idioma do seu sistema é: " + idioma.getDisplayLanguage() + " " + idioma.getLanguage());
    }
}
