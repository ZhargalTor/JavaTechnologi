package service;

import model.equipment.*;
import model.rider.Motorcyclist;

public class EquipmentService {

    public static void addDefaultEquipment(Motorcyclist motorcyclist) {
        Helmet helmet1 = new Helmet("Shoei GT-Air II", "Shoei", 1.65, 45000,
                "Fiberglass", "Black", "full-face", "clear", true);
        Helmet helmet2 = new Helmet("Arai RX-7V", "Arai", 1.55, 52000,
                "Fiberglass", "White", "full-face", "clear", false);

        Jacket jacket1 = new Jacket("Alpinestars GP Plus", "Alpinestars", 2.8, 28000,
                "Leather", "Black/Red", true, false, true);
        Jacket jacket2 = new Jacket("Dainese Racing 3", "Dainese", 2.5, 32000,
                "Leather", "Black/White", true, false, true);

        Gloves gloves1 = new Gloves("Alpinestars SP-8", "Alpinestars", 0.25, 6500,
                "Leather", "Black", "racing", true, true);
        Gloves gloves2 = new Gloves("Dainese Carbon 4", "Dainese", 0.22, 7800,
                "Leather", "Black/Red", "racing", true, true);

        Pants pants1 = new Pants("Alpinestars Andes", "Alpinestars", 1.8, 18500,
                "Textile", "Black", true, true, true);
        Pants pants2 = new Pants("Dainese Drake", "Dainese", 1.6, 16500,
                "Textile", "Black", true, true, false);

        Boots boots1 = new Boots("Alpinestars SMX-6", "Alpinestars", 2.2, 22000,
                "Leather", "Black", "racing", 25.0, true, true);
        Boots boots2 = new Boots("Dainese Torque D1", "Dainese", 2.0, 24500,
                "Leather", "Black/White", "racing", 24.5, true, true);

        Protection protection1 = new Protection("Alpinestars Nucleon", "Alpinestars", 0.45, 8500,
                "Polymer", "Black", "back protector", "Level 2", "CE EN1621-2");
        Protection protection2 = new Protection("Dainese Pro Armor", "Dainese", 0.38, 7800,
                "Polymer", "Black", "chest protector", "Level 2", "CE EN1621-3");

        motorcyclist.addEquipment(helmet1);
        motorcyclist.addEquipment(jacket1);
        motorcyclist.addEquipment(gloves1);
        motorcyclist.addEquipment(pants1);
        motorcyclist.addEquipment(boots1);
        motorcyclist.addEquipment(protection1);
    }

    public static void addFullEquipmentSet(Motorcyclist motorcyclist) {
        addDefaultEquipment(motorcyclist);

        Helmet helmet2 = new Helmet("Arai RX-7V", "Arai", 1.55, 52000,
                "Fiberglass", "White", "full-face", "clear", false);
        Jacket jacket2 = new Jacket("Dainese Racing 3", "Dainese", 2.5, 32000,
                "Leather", "Black/White", true, false, true);
        Gloves gloves2 = new Gloves("Dainese Carbon 4", "Dainese", 0.22, 7800,
                "Leather", "Black/Red", "racing", true, true);
        Pants pants2 = new Pants("Dainese Drake", "Dainese", 1.6, 16500,
                "Textile", "Black", true, true, false);
        Boots boots2 = new Boots("Dainese Torque D1", "Dainese", 2.0, 24500,
                "Leather", "Black/White", "racing", 24.5, true, true);
        Protection protection2 = new Protection("Dainese Pro Armor", "Dainese", 0.38, 7800,
                "Polymer", "Black", "chest protector", "Level 2", "CE EN1621-3");

        motorcyclist.addEquipment(helmet2);
        motorcyclist.addEquipment(jacket2);
        motorcyclist.addEquipment(gloves2);
        motorcyclist.addEquipment(pants2);
        motorcyclist.addEquipment(boots2);
        motorcyclist.addEquipment(protection2);
    }
}