package henry.court.monsterhunterplanner.jsonProcessing.rawData;

import henry.court.monsterhunterplanner.dataClasses.ArmArmor;
import henry.court.monsterhunterplanner.dataClasses.ArmorSkill;
import henry.court.monsterhunterplanner.dataClasses.LegArmor;

import java.util.Map;

public class RawLegArmor extends RawArmor{

    public RawLegArmor() {
        super();
    }

    public RawLegArmor(int index,
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

    public LegArmor toLegArmor(ArmorSkill[] armorSkills) {
        return new LegArmor(
                this.index, this.name, armorSkills, this.defense, this.resistances, this.rare, this.series, this.sexualEquipable, this.buildupTable, this.decorationsNumList
        );
    }
}
