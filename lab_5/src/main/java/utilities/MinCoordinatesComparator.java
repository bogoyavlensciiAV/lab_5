package utilities;

import models.Dragon;

import java.util.Comparator;

public class MinCoordinatesComparator implements Comparator<Dragon> {

    @Override
    public int compare(Dragon d1, Dragon d2) {
        return (int) (d1.sumCoordinates() - d2.sumCoordinates());
    }
}

