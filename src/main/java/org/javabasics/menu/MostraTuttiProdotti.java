package org.javabasics.menu;

import java.util.Map;

import org.javabasics.Models.Prodotti;

public class MostraTuttiProdotti {
    public static void mostraTuttiProdotti(Map<Integer, Prodotti> map) {
        for (Integer key : map.keySet()) {
            map.get(key).stampaTutto();
        }
    }
}