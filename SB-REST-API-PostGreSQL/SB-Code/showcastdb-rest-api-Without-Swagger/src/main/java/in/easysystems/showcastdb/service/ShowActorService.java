package in.easysystems.showcastdb.service;


import in.easysystems.showcastdb.dto.ShowActorDTO;

import java.util.List;
import java.util.UUID;

public interface ShowActorService {

    ShowActorDTO createActor( ShowActorDTO actorDTO);

    ShowActorDTO getActorById( UUID showActorId );

    List<ShowActorDTO> getAllActors();

    void updateActor( UUID showActorId, ShowActorDTO actorDTO );

    void updateActorShowName( UUID showActorId, String nameToUpdate );

    void deleteActor( UUID idToDelete );
}
