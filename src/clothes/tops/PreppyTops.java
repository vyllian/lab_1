package clothes.tops;

import clothes.Colour;

import java.util.Random;

public class PreppyTops extends Top {
    // constructor
    public PreppyTops(String colour){
        this.setStyle("Preppy");
        this.setItem(this.chooseItem());
        if (colour.isEmpty()){
            Colour col = new Colour();
            this.setColour(col.assignColour());}
        else this.setColour(colour);
        this.setPoints_grow(20);
    }
    // override method
    public String chooseItem (){
        return new Random().nextBoolean() ? "vest": "cardigan";
    }


}
