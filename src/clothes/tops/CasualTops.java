package clothes.tops;

import clothes.Colour;
import java.util.Random;

public class CasualTops extends Top {
// constructor
    public CasualTops(String colour){
        this.setStyle("Casual");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());}
        else this.setColour(colour);
        this.setPoints_grow(16);
    }
// override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "t-shirt" : "sweater";
    }


}


