package henry.court.monsterhunterplanner.dataClasses;

import java.util.Map;

public class HeadArmor extends Armor {

    public HeadArmor(int index,
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

    public HeadArmor () {
        super();
    }

}
