package lab2;

/**
 * A stand-alone freezer unit.
 * @author {@code Maxwell Terpstra <C0380979@intra.camosun.bc.ca>}
 */
public class Freezer implements Cargo {
    public enum Size {
        CHEST("5x3x4"),
        UPRIGHT("3x3x5"),
        DRAWER("2x2x4");
        private String actual;
        Size(String s) {
            this.actual = s;
        }
        String dimensions() { return this.actual; }
    }

    /**
     * Whether or not the freezer door is open.
     */
    public boolean open = false;
    private int weight =1;
    private String color = "pink";
    private int temp;
    private final Size size;
    private final boolean electric;
    private final boolean waterFlow;

    /**
     * Constructs a Freezer of the given type.
     * @param s freezer size
     * @param electric whether or not the freezer uses electricity
     * @param water whether or not the
     */
    public Freezer(Size s, boolean electric, boolean water) {
        this.size = s;
        this.temp = 1;
        this.electric = electric;
        this.waterFlow = water;
    }

    /**
     * Return the dimensions of this Freezer in feet as a
     * {@code <width>x<depth>x<height>} String value.
     * @return dimensions in feet
     */
    public String size() { return this.size.dimensions(); }


    @Override
    public void showInfos() {
        System.out.println(this.getClass().getSimpleName()+" ,is used to reserve food");
    }

    /**
     * Whether or not this freezer requires an electrical hookup.
     * @return true if the freezer uses electricity
     */
    public boolean isNeedsElectricity() { return true; }

    /**
     * Whether or not this freezer requires a water-line hookup.
     * @return true if the freezer uses water
     */
    public boolean needsWater() { return this.waterFlow; }

    /**
     * Get the current temperature setting
     * @return a unitless setting number, from 0 to 5
     */
    public int getTemperature() {
        return this.temp;
    }

    /**
     * Change the freezer temperature setting.
     * @param t temperature setting, from 0 to 5
     */
    public void setTemperature(int t) {
        if (t <= 0) {
            this.temp = 0;
        } else if (t >= 5) {
            this.temp = 5;
        } else {
            this.temp = t;
        }
    }
}