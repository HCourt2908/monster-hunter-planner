package henry.court.monsterhunterplanner.jsonProcessing.rawData;

import henry.court.monsterhunterplanner.dataClasses.ArmArmor;
import henry.court.monsterhunterplanner.dataClasses.ArmorSkill;

import java.util.Map;

public class RawArmArmor extends RawArmor {

    public RawArmArmor() {
        super();
    }

    public RawArmArmor(int index,
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

    public ArmArmor toArmArmor(ArmorSkill[] armorSkills) {
        return new ArmArmor(
                this.index, this.name, armorSkills, this.defense, this.resistances, this.rare, this.series, this.sexualEquipable, this.buildupTable, this.decorationsNumList
        );
    }

}
