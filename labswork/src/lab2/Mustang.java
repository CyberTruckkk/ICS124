package lab2;

import java.time.LocalDate;

/**
 * THIS CLASS MUSTANG is extended from super Class Horse

 */
public class Mustang extends Horse implements Cargo {
    public int speed = 100;

    /**
     * description
     * @param breed of this mustang like arabic
     * @param name of this mustang
     * @param born borddate ,use int year ,int ,day number of this year
     * @param speed  Default speed is set to 100 ,if speed is greatter than 100 ,its speed will be set to the speed
     */
    public Mustang(String breed, String name, LocalDate born, int speed) {
        super(breed, name, born);
        if (speed > 100) {
            this.speed = speed;
        }

    }

    public void showInfos() {
        super.showInfos();
        System.out.println(", this mustang " + this.name + "  runs " + this.speed + " MPH");

    }
}
