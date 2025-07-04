package henry.court.monsterhunterplanner.dataClasses;

public class ArmArmor {

    public int index;
    public String name;
    public ArmorSkill[] armorSkills;
    public int defense;
    public int[] resistances;

    public ArmArmor(int index, String name, ArmorSkill[] armorSkills, int defense, int[] resistances) {
        this.index = index;
        this.name = name;
        this.armorSkills = armorSkills;
        this.defense = defense;
        this.resistances = resistances;
    }

}
