package henry.court.monsterhunterplanner.controller;

import henry.court.monsterhunterplanner.dataClasses.*;
import henry.court.monsterhunterplanner.jsonProcessing.ArmorService;
import henry.court.monsterhunterplanner.jsonProcessing.Skill;
import henry.court.monsterhunterplanner.jsonProcessing.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final SkillService skillService;
    private final ArmorService armorService;

    public MenuController(SkillService skillService, ArmorService armorService) {
        this.skillService = skillService;
        this.armorService = armorService;
    }

    @GetMapping("/menu")
    String menu(Model model) {
        List<Skill> skills = skillService.getSkills();
        model.addAttribute("skills", skills);
        List<ArmArmor> lrArmArmor = armorService.getArmArmorList();
        model.addAttribute("lrArmArmor", lrArmArmor);
        List<BodyArmor> lrBodyArmor = armorService.getBodyArmorList();
        model.addAttribute("lrBodyArmor", lrBodyArmor);
        List<HeadArmor> lrHeadArmor = armorService.getHeadArmorList();
        model.addAttribute("lrHeadArmor", lrHeadArmor);
        List<LegArmor> lrLegArmor = armorService.getLegArmorList();
        model.addAttribute("lrLegArmor", lrLegArmor);
        List<WaistArmor> lrWaistArmor = armorService.getWaistArmorList();
        model.addAttribute("lrWaistArmor", lrWaistArmor);
        return "menu";
    }

}
