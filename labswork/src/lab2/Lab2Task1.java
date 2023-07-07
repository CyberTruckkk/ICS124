package lab2;

import java.time.LocalDate;

/**
 * @author c0527253
 */
public class Lab2Task1 {

    /**
     * @param args the command line arguments
     *             Horse ,Mustang ,Freezer Bicycle ,they are all Cargos, use isNeedElectricty and show() to get there infomations;
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Cargo p1 = new Horse("guoxia", "Pony", LocalDate.ofYearDay(2020, 90));
        Cargo p2 = new Bicycle(80, false, false);
        Cargo p3 = new Freezer(Freezer.Size.CHEST, true, false);
        Cargo p4 = new Mustang("Arabic", "jacky", LocalDate.ofYearDay(2022, 100), 99);

        Cargo[] cas = new Cargo[5];
        cas[0] = p1;
        cas[1] = p1;
        cas[2] = p2;
        cas[3] = p3;
        cas[4] = p4;

        for (Cargo ca :cas){
            ca.showInfos();
        }
    }
}
