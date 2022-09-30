package accessory;
import arena.Arena;
import clothes.Outfit;
import java.io.BufferedWriter;
import java.io.IOException;

public class Cap extends Accessory{
    // constructor
    public Cap(){
        this.setItem("cap");
    }
    @Override
    public int Accessory_points(BufferedWriter writer,Arena arena, Outfit droid, Outfit enemy, String mode) {
        switch (arena.getName()){
            case "Theatre": return -5;
            case "Park":
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
                return 10;
            default: return 0;
        }
    }
}
