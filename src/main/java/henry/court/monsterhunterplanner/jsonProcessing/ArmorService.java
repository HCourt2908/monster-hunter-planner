package henry.court.monsterhunterplanner.jsonProcessing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import henry.court.monsterhunterplanner.dataClasses.ArmArmor;
import henry.court.monsterhunterplanner.dataClasses.ArmorSkill;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArmorService {

    private final ObjectMapper objectMapper;
    private final SkillService skillService;

    @Getter
    private List<ArmArmor> armArmorList;

    public ArmorService(ObjectMapper objectMapper, SkillService skillService) {
        this.objectMapper = objectMapper;
        this.skillService = skillService;
    }

    @PostConstruct
    public void init() throws Exception{
        ClassPathResource resource = new ClassPathResource("data/lr/armor_arm_lr.json");

        try (InputStream is = resource.getInputStream()) {
            List<RawArmArmor> rawArmArmorList = objectMapper.readValue(is, new TypeReference<>() {});

            armArmorList = rawArmArmorList.stream()
                    .map(this::convertRawToReal)
                    .collect(Collectors.toList());
        }
    }

    public ArmArmor convertRawToReal(RawArmArmor rawArmArmor) {
        ArmorSkill[] armorSkills = rawArmArmor.skills == null ? new ArmorSkill[0] :
                Arrays.stream(rawArmArmor.skills)
                        .map(rawSkill -> new ArmorSkill(
                                skillService.getSkillById(rawSkill.getId()),
                                rawSkill.level
                        ))
                        .toArray(ArmorSkill[]::new);

        return new ArmArmor(
                rawArmArmor.index,
                rawArmArmor.name,
                armorSkills,
                rawArmArmor.defense,
                rawArmArmor.resistances,
                rawArmArmor.rare,
                rawArmArmor.series,
                rawArmArmor.sexualEquipable,
                rawArmArmor.buildupTable,
                rawArmArmor.decorationsNumList
        );
    }

}
