package service;

import model.equipment.*;
import model.rider.Motorcyclist;

public class EquipmentService {

    public static void addDefaultEquipment(Motorcyclist motorcyclist) {
        Helmet helmet = new Helmet("Shoei GT-Air II", "Shoei", 1.65, 45000,
                "Fiberglass", "Black", "full-face", "clear");

        Jacket jacket = new Jacket("Alpinestars GP Plus", "Alpinestars", 2.8, 28000,
                "Leather", "Black/Red", true, true);

        Gloves gloves = new Gloves("Alpinestars SP-8", "Alpinestars", 0.25, 6500,
                "Leather", "Black", "racing", true);

        Pants pants = new Pants("Alpinestars Andes", "Alpinestars", 1.8, 18500,
                "Textile", "Black", true, true);

        Boots boots = new Boots("Alpinestars SMX-6", "Alpinestars", 2.2, 22000,
                "Leather", "Black", "racing", true);

        Protection protection = new Protection("Alpinestars Nucleon", "Alpinestars", 0.45, 8500,
                "Polymer", "Black", "back protector", "Level 2");

        motorcyclist.addEquipment(helmet);
        motorcyclist.addEquipment(jacket);
        motorcyclist.addEquipment(gloves);
        motorcyclist.addEquipment(pants);
        motorcyclist.addEquipment(boots);
        motorcyclist.addEquipment(protection);
    }
}