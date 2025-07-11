package henry.court.monsterhunterplanner.jsonProcessing.rawData;

import henry.court.monsterhunterplanner.dataClasses.ArmArmor;
import henry.court.monsterhunterplanner.dataClasses.ArmorSkill;
import henry.court.monsterhunterplanner.dataClasses.HeadArmor;

import java.util.Map;

public class RawHeadArmor extends RawArmor{

    public RawHeadArmor() {
        super();
    }

    public RawHeadArmor(int index,
                       String name,
                       RawArmorSkill[] skills,
                       int defense,
                       Map<String, Integer> resistances,
                       int rare,
                       int series,
                       String sexualEquipable,
                       int buildupTable,
                       int[] decorationsNumList) {
        super(index, name, skills, defense, resistances, rare, series, sexualEquipable, buildupTable, decorationsNumList);
    }

    public HeadArmor toHeadArmor(ArmorSkill[] armorSkills) {
        return new HeadArmor(
                this.index, this.name, armorSkills, this.defense, this.resistances, this.rare, this.series, this.sexualEquipable, this.buildupTable, this.decorationsNumList
        );
    }
}
