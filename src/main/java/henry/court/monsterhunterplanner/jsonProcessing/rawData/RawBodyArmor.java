package henry.court.monsterhunterplanner.jsonProcessing.rawData;

import henry.court.monsterhunterplanner.dataClasses.ArmArmor;
import henry.court.monsterhunterplanner.dataClasses.ArmorSkill;
import henry.court.monsterhunterplanner.dataClasses.BodyArmor;

import java.util.Map;

public class RawBodyArmor extends RawArmor{

    public RawBodyArmor() {
        super();
    }

    public RawBodyArmor(int index,
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

    public BodyArmor toBodyArmor(ArmorSkill[] armorSkills) {
        return new BodyArmor(
                this.index, this.name, armorSkills, this.defense, this.resistances, this.rare, this.series, this.sexualEquipable, this.buildupTable, this.decorationsNumList
        );
    }
}
