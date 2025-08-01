package henry.court.monsterhunterplanner.jsonProcessing.rawData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawArmorSkill {

    @JsonProperty("skill_id")
    public int id;
    public int level;

}
