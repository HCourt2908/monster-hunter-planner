package henry.court.monsterhunterplanner.dataClasses;

import henry.court.monsterhunterplanner.jsonProcessing.Skill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArmorSkill {

    public Skill skill;
    public int level;

    public ArmorSkill(Skill skill, int level) {
        this.skill = skill;
        this.level = level;
    }

    @Override
    public String toString() {
        return skill.getName() + ":" + level;
    }

}
