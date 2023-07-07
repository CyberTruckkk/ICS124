package lab2;

/**
 * Horse ,Mustang ,Freezer Bicycle ,they are all Cargos, use isNeedElectricty and show() to get there infomations;
 *
 */
public interface Cargo {

    /**
     * this method show what they do ,there name or anything usefull for their customers
     */
    public void showInfos();
    public boolean isNeedsElectricity();

}
