package org.chess;

import org.chess.entity.models.Figure;

import java.util.HashSet;
import java.util.Set;

public class Utils {
    public static Set<Figure> copyValuesInSet(Set<Figure> set){
        Set<Figure> newSet = new HashSet<>();
        for (Figure val : set){
            newSet.add(val.clone());
        }

        return newSet;
    }
}
