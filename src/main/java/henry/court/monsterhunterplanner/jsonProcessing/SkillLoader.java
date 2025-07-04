package henry.court.monsterhunterplanner.jsonProcessing;


import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Component
@Profile("!test")
public class SkillLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        ClassPathResource resource = new ClassPathResource("data/player_skills.json");
        try (InputStream is = resource.getInputStream()) {
            List<Skill> skills = mapper.readValue(is, new TypeReference<List<Skill>>() {});
            System.out.println(skills.get(0));
        }
    }
}
