package in.easysystems.showcastdb.dto;

import java.util.UUID;

// DTO class is used to transfer Data between DTO and Mapper so it can be immutable so we use Record over here
// Also we get Constructor, Getters and Setters, equals(), hashCode() and toString() methods by default eliminating Boilerplate code
public record ShowActorDTO(
                            UUID actorID,
                            String showName,
                            String actorShowName,
                            String actorRealName
                        ) {
}
