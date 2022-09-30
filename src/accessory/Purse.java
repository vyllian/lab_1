package accessory;

import arena.Arena;
import clothes.Outfit;

import java.io.BufferedWriter;
import java.io.IOException;

public class Purse extends Accessory{
    // constructor
    public Purse(){
        this.setItem("purse");
    }
    @Override
    public int Accessory_points(BufferedWriter writer, Arena arena, Outfit droid, Outfit enemy, String mode) {
        switch (arena.getName()){
            case "University": return -5;
            case "Theatre":
                enemy.setOutfit_points(-5);
                if (mode.equals("console"))
                    System.out.println("~"+droid.getName()+"'s taking "+enemy.getName()+"'s points~");
                else {
                    try {
                        writer.write("~"+droid.getName()+"'s taking "+enemy.getName()+"'s points~");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return 5;
            case "Cafe": return 10;
            default: return 0;
        }
    }
}
