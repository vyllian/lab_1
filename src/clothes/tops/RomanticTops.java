package clothes.tops;

import clothes.Colour;

import java.util.Random;

public class RomanticTops extends Top {
   // constructor
    public RomanticTops(String colour){
        this.setStyle("Romantic");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());}
        else this.setColour(colour);
        this.setPoints_grow(16);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "blouse" : "corset";
    }

}
