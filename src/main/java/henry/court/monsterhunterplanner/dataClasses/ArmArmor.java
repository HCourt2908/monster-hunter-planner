package henry.court.monsterhunterplanner.dataClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

public class ArmArmor extends Armor {

    public ArmArmor(int index,
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

    public ArmArmor () {
        super();
    }

}
