package clothes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Colour {
     String[] allcolours = new String[]{"black","white","red", "beige","green", "brown", "grey","orange", "pink","blue"};
     String[] casual_colours = new String[] {"black","white", "brown", "grey","blue"};
     String[] romantic_colours = new String[] {"white", "beige", "orange", "pink","blue"};
     String[] preppy_colours = new String[] {"black","white","red", "brown", "green"};

    /**
     * Randomly chooses colour to item
     * @return colour name
     */
     public  String assignColour (){
        Random rand = new Random();
        return allcolours[rand.nextInt(allcolours.length-1)];
    }

    /**
     * Checks if the colour is appropriate for a style
     * @param colour colour name
     * @param style style name
     * @return true/false
     */
     public boolean isAppropriateColour(String colour, String style) {
        List<String> pref_colours;
        switch (style) {
            case "Casual":
                pref_colours = Arrays.asList(casual_colours);
                break;
            case "Romantic":
                pref_colours = Arrays.asList(romantic_colours);
                break;
            case "Preppy":
                pref_colours = Arrays.asList(preppy_colours);
                break;
            case "Basic":
                return true;
            default: return false;
        }
        return pref_colours.contains(colour);
    }

    /**
     * Prints all colours
     * @return all colours as 1 string
     */
     public String getAllColours(){
        String colours = allcolours[0];
        for(int i=1; i<allcolours.length; i++){
            colours += ", "+allcolours[i];
        }
        return colours;
    }


}
