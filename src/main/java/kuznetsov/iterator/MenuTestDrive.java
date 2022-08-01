package kuznetsov.iterator;

import kuznetsov.iterator.diner_menu.DinerMenu;
import kuznetsov.iterator.menu.Menu;
import kuznetsov.iterator.pancake_house_menu.PancakeHouseMenu;

import java.util.ArrayList;

public class MenuTestDrive {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(pancakeHouseMenu);
        menus.add(dinerMenu);

        Waitress waitress = new Waitress(menus);
        waitress.printMenu();
    }
}
