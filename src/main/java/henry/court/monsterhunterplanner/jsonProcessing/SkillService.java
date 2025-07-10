package henry.court.monsterhunterplanner.jsonProcessing;


import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Getter
    public List<Skill> skills;
    public Map<Integer, Skill> skillsMap;

    @PostConstruct
    public void init() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("data/raw/player_skills.json");
        try (InputStream is = resource.getInputStream()) {
            skills = mapper.readValue(is, new TypeReference<>() {
            });
            skillsMap = skills.stream().collect(Collectors.toMap(Skill::getId, Function.identity()));
        }
    }

    public Skill getSkillById(int id) {
        return skillsMap.get(id);
    }
}
