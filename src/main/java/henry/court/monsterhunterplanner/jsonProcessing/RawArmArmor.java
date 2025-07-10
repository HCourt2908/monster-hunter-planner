package henry.court.monsterhunterplanner.jsonProcessing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawArmArmor {

    @JsonProperty("armor_index")
    public int index;

    public String name;
    public RawArmorSkill[] skills;
    public int defense;
    public Map<String, Integer> resistances;
    public int rare;
    public int series;

    @JsonProperty("sexual_equipable")
    public String sexualEquipable;

    @JsonProperty("buildup_table")
    public int buildupTable;

    @JsonProperty("decorations_num_list")
    public int[] decorationsNumList;

}
