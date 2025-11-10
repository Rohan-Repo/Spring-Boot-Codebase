package in.easysystems.showcastdb.dto;

import java.util.UUID;

public record ActorDetailsDTO(
        String showName,
        String actorShowName,
        String actorRealName
) {}