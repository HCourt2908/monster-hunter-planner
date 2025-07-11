package henry.court.monsterhunterplanner.jsonProcessing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import henry.court.monsterhunterplanner.dataClasses.*;
import henry.court.monsterhunterplanner.jsonProcessing.rawData.*;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ArmorService {

    private final ObjectMapper objectMapper;
    private final SkillService skillService;

    @Getter
    private List<ArmArmor> armArmorList;
    @Getter
    private List<BodyArmor> bodyArmorList;
    @Getter
    private List<HeadArmor> headArmorList;
    @Getter
    private List<LegArmor> legArmorList;
    @Getter
    private List<WaistArmor> waistArmorList;

    public ArmorService(ObjectMapper objectMapper, SkillService skillService) {
        this.objectMapper = objectMapper;
        this.skillService = skillService;
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() throws Exception{
        ClassPathResource armArmorLR = new ClassPathResource("data/lr/armor_arm_lr.json");
        armArmorList = (List<ArmArmor>) convertJsonToObjects(armArmorLR, "arm");
        ClassPathResource bodyArmorLR = new ClassPathResource("data/lr/armor_body_lr.json");
        bodyArmorList = (List<BodyArmor>) convertJsonToObjects(bodyArmorLR, "body");
        ClassPathResource headArmorLR = new ClassPathResource("data/lr/armor_head_lr.json");
        headArmorList = (List<HeadArmor>) convertJsonToObjects(headArmorLR, "head");
        ClassPathResource legArmorLR = new ClassPathResource("data/lr/armor_leg_lr.json");
        legArmorList = (List<LegArmor>) convertJsonToObjects(legArmorLR, "leg");
        ClassPathResource waistArmorLR = new ClassPathResource("data/lr/armor_waist_lr.json");
        waistArmorList = (List<WaistArmor>) convertJsonToObjects(waistArmorLR, "waist");

    }

    public List<? extends Armor> convertJsonToObjects(ClassPathResource resource, String armorType) throws Exception{
        try (InputStream is = resource.getInputStream()) {
            switch (armorType) {
                case "arm" -> {
                    List<RawArmArmor> rawArmorList = objectMapper.readValue(is, new TypeReference<>() {});
                    return rawArmorList.stream().map(x -> convertRawToReal(x, x::toArmArmor)).collect(Collectors.toList());
                } case "body" -> {
                    List<RawBodyArmor> rawArmorList = objectMapper.readValue(is, new TypeReference<>() {});
                    return rawArmorList.stream().map(x -> convertRawToReal(x, x::toBodyArmor)).collect(Collectors.toList());
                } case "head" -> {
                    List<RawHeadArmor> rawArmorList = objectMapper.readValue(is, new TypeReference<>() {});
                    return rawArmorList.stream().map(x -> convertRawToReal(x, x::toHeadArmor)).collect(Collectors.toList());
                } case "leg" -> {
                    List<RawLegArmor> rawArmorList = objectMapper.readValue(is, new TypeReference<>() {});
                    return rawArmorList.stream().map(x -> convertRawToReal(x, x::toLegArmor)).collect(Collectors.toList());
                } case "waist" -> {
                    List<RawWaistArmor> rawArmorList = objectMapper.readValue(is, new TypeReference<>() {});
                    return rawArmorList.stream().map(x -> convertRawToReal(x, x::toWaistArmor)).collect(Collectors.toList());
                }default -> {
                    return null;
                }
            }
        }
    }

    public <R extends RawArmor, M extends Armor> M convertRawToReal(R rawArmor, Function<ArmorSkill[], M> converter) {
        try {
            ArmorSkill[] armorSkills = rawArmor.skills == null ? new ArmorSkill[0] :
                    Arrays.stream(rawArmor.skills)
                            .map(rawSkill -> new ArmorSkill(
                                    skillService.getSkillById(rawSkill.getId()),
                                    rawSkill.level
                            ))
                            .toArray(ArmorSkill[]::new);

            return converter.apply(armorSkills);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
