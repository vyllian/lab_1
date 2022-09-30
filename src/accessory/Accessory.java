package accessory;

import arena.Arena;
import clothes.Outfit;

import java.io.BufferedWriter;

public abstract class Accessory {
    private String item;

//setter and getter
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Defines points for every accessory due to arena
     * @param writer for file input
     * @param arena arena
     * @param droid player 1
     * @param enemy player 2
     * @param mode writing to a file or console
     * @return number of points
     */
    public abstract int Accessory_points(BufferedWriter writer, Arena arena, Outfit droid, Outfit enemy, String mode);

    @Override
    public String toString() {
        return item;
    }
}
