package henry.court.monsterhunterplanner.jsonProcessing;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Skill {

    public int id;
    public String name;
    public int max;

    public Skill(int id, String name, int max) {
        this.id = id;
        this.name = name;
        this.max = max;
    }

    public Skill() {

    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + ", max=" + max + "]";
    }



}
