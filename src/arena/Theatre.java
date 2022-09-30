package arena;

public class Theatre extends Arena {
    // constructor
    public Theatre (){
        this.setName("Theatre");
        this.setPreferable_style("Romantic");
    }
// override
    public double coeff(String style) {
        return switch (style) {
            case "Romantic", "Basic" -> 1.0;
            case "Preppy" -> 0.5;
            default -> -0.5;
        };
    }

}
