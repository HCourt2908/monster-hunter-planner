package henry.court.monsterhunterplanner.dataClasses;

import henry.court.monsterhunterplanner.jsonProcessing.Skill;

public class ArmorSkill {

    public Skill skill;
    public int level;

    public ArmorSkill(Skill skill, int level) {
        this.skill = skill;
        this.level = level;
    }

}
