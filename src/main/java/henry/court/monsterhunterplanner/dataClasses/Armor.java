package henry.court.monsterhunterplanner.dataClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Armor {

    public int index;
    public String name;
    public ArmorSkill[] armorSkills;
    public int defense;
    public Map<String, Integer> resistances;
    public int rare;
    public int series;
    public String sexualEquipable;
    public int buildupTable;
    public int[] decorationsNumList;

}
