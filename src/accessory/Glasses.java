package accessory;

import arena.Arena;
import clothes.Outfit;

import java.io.BufferedWriter;
import java.io.IOException;

public class Glasses extends Accessory{
    // constructor
    public Glasses(){
        this.setItem("glasses");
    }
    @Override
    public int Accessory_points(BufferedWriter writer,Arena arena, Outfit droid, Outfit enemy, String mode) {
        switch (arena.getName()){
            case "University": return 10;
            case "Park" : return -5;
            case "Cafe":
                if (mode.equals("console"))
                    System.out.println("~"+droid.getName()+"'s taking "+enemy.getName()+"'s points~");
                else {
                    try {
                        writer.write("~"+droid.getName()+"'s taking "+enemy.getName()+"'s points~");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                enemy.setOutfit_points(-5);
            default: return 0;
        }
    }
}
