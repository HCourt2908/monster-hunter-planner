package henry.court.monsterhunterplanner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import henry.court.monsterhunterplanner.dataClasses.*;
import henry.court.monsterhunterplanner.jsonProcessing.ArmorService;
import henry.court.monsterhunterplanner.jsonProcessing.Skill;
import henry.court.monsterhunterplanner.jsonProcessing.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    private final SkillService skillService;
    private final ArmorService armorService;
    private final ObjectMapper objectMapper;

    public MenuController(SkillService skillService, ArmorService armorService, ObjectMapper objectMapper) {
        this.skillService = skillService;
        this.armorService = armorService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/menu")
    String menu(Model model) throws JsonProcessingException {
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

        Map<Integer, String> lrArmJSONMap = new HashMap<>();
        for (ArmArmor armor : lrArmArmor) {
            lrArmJSONMap.put(armor.getIndex(), objectMapper.writeValueAsString(armor.getArmorSkills()));
        }
        model.addAttribute("lrArmJSONMap", lrArmJSONMap);

        Map<Integer, String> lrBodyJSONMap = new HashMap<>();
        for (BodyArmor armor : lrBodyArmor) {
            lrBodyJSONMap.put(armor.getIndex(), objectMapper.writeValueAsString(armor.getArmorSkills()));
        }
        model.addAttribute("lrBodyJSONMap", lrBodyJSONMap);

        Map<Integer, String> lrHeadJSONMap = new HashMap<>();
        for (HeadArmor armor : lrHeadArmor) {
            lrHeadJSONMap.put(armor.getIndex(), objectMapper.writeValueAsString(armor.getArmorSkills()));
        }
        model.addAttribute("lrHeadJSONMap", lrHeadJSONMap);

        Map<Integer, String> lrLegJSONMap = new HashMap<>();
        for (LegArmor armor : lrLegArmor) {
            lrLegJSONMap.put(armor.getIndex(), objectMapper.writeValueAsString(armor.getArmorSkills()));
        }
        model.addAttribute("lrLegJSONMap", lrLegJSONMap);

        Map<Integer, String> lrWaistJSONMap = new HashMap<>();
        for (WaistArmor armor : lrWaistArmor) {
            lrWaistJSONMap.put(armor.getIndex(), objectMapper.writeValueAsString(armor.getArmorSkills()));
        }
        model.addAttribute("lrWaistJSONMap", lrWaistJSONMap);

        return "menu";
    }

}
