package in.easysystems.showcastdb.service;


import in.easysystems.showcastdb.dto.ActorDetailsDTO;
import in.easysystems.showcastdb.dto.ShowActorDTO;

import java.util.List;
import java.util.UUID;

public interface ShowActorService {

    ShowActorDTO createActor( ShowActorDTO actorDTO);

    ShowActorDTO getActorById( String showActorId );

    List<ShowActorDTO> getAllActors();

    void updateActor( String showActorId, ShowActorDTO actorDTO );

    void updateActorShowName( String showActorId, String nameToUpdate );

    void deleteActor( String idToDelete );

    List<ActorDetailsDTO> getActorDetailsWithoutId();
}
