package in.easysystems.showcastdb.repository;

import in.easysystems.showcastdb.entity.ShowActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

// As we are extending the JpaRepository we don't need to add the @Repository annotation
// JpaRepository<TypeOfEntity, PrimaryKey DataType>
// All public methods are transactional in nature so we don't need to add the @Transactional annotation in the service class
public interface ShowActorRepository extends JpaRepository<ShowActor, UUID> {

    /*  By extending JpaRepository ShowActorRepository automatically inherits methods to
        perform DB operations without having to write manual SQL queries or any implementation logic
        Spring Data JPA will automatically create the implementation at Runtime
        Thus no BoilerPlate, Auto Implementation and Built in pagination and sorting   */

    // @Modifying: Tells Spring this query changes data.
    @Modifying
    // @Transactional: Ensures update is committed properly (add to repo or in the service method).
    @Transactional
    @Query( "UPDATE ShowActor sa SET sa.actorShowName = :updatedName WHERE sa.actorID= :id")
    // These should be the values in JPA Entity and not the ones from DB - Not allowed like below
    //  UPDATE show_character_actor_names sa SET sa.actor_show_name = :updatedName WHERE sa.actor_id = :id
    // This returns the number of Updated rows
    int updateActorShowName( @Param("id") UUID id, @Param("updatedName") String updatedName );
}
