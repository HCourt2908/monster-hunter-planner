package henry.court.monsterhunterplanner.dataClasses;

public class HeadArmor {

    public int index;
    public String name;
    public ArmorSkill[] armorSkills;
    public int defense;
    public int[] resistances;

    public HeadArmor(int index, String name, ArmorSkill[] armorSkills, int defense, int[] resistances) {
        this.index = index;
        this.name = name;
        this.armorSkills = armorSkills;
        this.defense = defense;
        this.resistances = resistances;
    }

}
