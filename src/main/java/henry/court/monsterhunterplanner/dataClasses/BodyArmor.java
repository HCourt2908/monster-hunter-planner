package henry.court.monsterhunterplanner.dataClasses;


import java.util.Map;

public class BodyArmor extends Armor{

    public BodyArmor(int index,
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

    public BodyArmor () {
        super();
    }




}
