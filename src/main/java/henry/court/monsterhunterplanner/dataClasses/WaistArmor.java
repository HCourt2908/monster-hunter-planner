package henry.court.monsterhunterplanner.dataClasses;

import java.util.Map;

public class WaistArmor extends Armor{

    public WaistArmor(int index,
                    String name,
                    ArmorSkill[] armorSkills,
                    int defense,
                    Map<String, Integer> resistances,
                    int rare,
                    int series,
                    String sexualEquipable,
                    int buildupTable,
                    int[] decorationsNumList) {
        super(index, name, armorSkills, defense, resistances, rare, series, sexualEquipable, buildupTable, decorationsNumList);
    }

    public WaistArmor () {
        super();
    }

}
