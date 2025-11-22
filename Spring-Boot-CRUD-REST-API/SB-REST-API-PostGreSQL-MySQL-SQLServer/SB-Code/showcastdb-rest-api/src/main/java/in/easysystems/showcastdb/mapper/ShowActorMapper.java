package in.easysystems.showcastdb.mapper;

import in.easysystems.showcastdb.dto.ShowActorDTO;
import in.easysystems.showcastdb.entity.ShowActor;
import org.springframework.stereotype.Component;

@Component
// @Component to map the class as a Spring Bean
public class ShowActorMapper {

    public ShowActorDTO convertToDTO(ShowActor actor){
        // Getter methods from JPA Entity
        return new ShowActorDTO(
                actor.getActorID(),
                actor.getShowName(),
                actor.getActorShowName(),
                actor.getActorRealName()
        );
    }

    public ShowActor convertToJPAEntity(ShowActorDTO actorDTO){
        // Getter methods from Record DTO
        return new ShowActor(
                actorDTO.actorID(),
                actorDTO.showName(),
                actorDTO.actorShowName(),
                actorDTO.actorRealName()
        );
    }
}
