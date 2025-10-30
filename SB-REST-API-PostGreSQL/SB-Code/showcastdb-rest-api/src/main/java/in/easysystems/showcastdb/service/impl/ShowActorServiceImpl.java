package in.easysystems.showcastdb.service.impl;

import in.easysystems.showcastdb.dto.ShowActorDTO;
import in.easysystems.showcastdb.entity.ShowActor;
import in.easysystems.showcastdb.exceptions.ResourceNotFoundException;
import in.easysystems.showcastdb.mapper.ShowActorMapper;
import in.easysystems.showcastdb.repository.ShowActorRepository;
import in.easysystems.showcastdb.service.ShowActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.UUID;

// Implementation Class for ShowActorService Interface to add our business logic
@Service
// @Service tells Spring to automatically create the Bean for this class so we can use @AutoWired
public class ShowActorServiceImpl implements ShowActorService {

    private final ShowActorRepository actorRepository;
    private final ShowActorMapper actorMapper;

    @Autowired
    public ShowActorServiceImpl(ShowActorRepository actorRepository, ShowActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
    }

    @Override
    public ShowActorDTO createActor(ShowActorDTO actorDTO) {
        // Convert DTO to JPA Entity using Mapper
        ShowActor showActor = actorMapper.convertToJPAEntity( actorDTO );

        // Save JPA Entity object to the DB using JpaRepository
        // Whatever Actor Details were saved we store them into savedActor
        ShowActor savedActor = actorRepository.save( showActor );

        // Convert JPA Entity back to DTO using Mapper
        return actorMapper.convertToDTO(savedActor);
    }

    @Override
    public ShowActorDTO getActorById(UUID showActorId) {
        // If actor with ID is not found send a custom exception - ResourceNotFoundException - Optional
        // Otherwise return the foundActor value
        ShowActor foundActor = actorRepository.findById( showActorId ).orElseThrow(
                () ->  new ResourceNotFoundException( "Actor with ID : " + showActorId.toString() + " was not found!" ));

        // Convert JPA Entity back to DTO using Mapper
        return actorMapper.convertToDTO( foundActor );
    }

    @Override
    public List<ShowActorDTO> getAllActors() {

        // Sort the Actor Data in Descending Order of ShowName
        List<ShowActor> allActors =
                actorRepository.findAll( Sort.by( Sort.Direction.DESC, "showName") );

                // Sort values should be the property from JPA Entity showName and not DB "show_name"
                // actorRepository.findAll( Sort.by( Sort.Direction.DESC, "show_name") );
                // actorRepository.findAll(); // Without Sorting


        // Stream through all JPA Entities and convert them into DTO's with map and then create a List
        // convertToDTO is being used as a method reference of ShowActorMapper object
        return
                allActors
                        .stream()
                        .map( actorMapper::convertToDTO )
                        .toList();

    }

    @Override
    public void updateActor(UUID showActorId, ShowActorDTO actorDataToChangeDTO) {

        // First let's get the User by their ID and if not found we need to throw a ResourceNotFoundException
        ShowActor foundActor = actorRepository.findById( showActorId ).orElseThrow(
                () ->  new ResourceNotFoundException( "Actor with ID : " + showActorId.toString() + " was not found!" ));

        foundActor.setShowName( actorDataToChangeDTO.showName() );
        foundActor.setActorRealName( actorDataToChangeDTO.actorRealName() );
        foundActor.setActorShowName( actorDataToChangeDTO.actorShowName() );

        // We will use JPARepository's save() method
        // If the ID is FOUND it will UPDATE the details
        // If the ID is NOT FOUND it will INSERT the details
        actorRepository.save( foundActor );
    }

    // This would be one approach, fetch and then update the single value, but instead we will use JPQL in the Repository layer and write a JPQL native query to circumvent fetching the Data
    /*
    @Override
    public ShowActorDTO updateActorShowName(UUID showActorId, String nameToUpdate) {
        // First let's get the User by their ID and if not found we need to throw a ResourceNotFoundException
        ShowActor foundActor = actorRepository.findById( showActorId ).orElseThrow(
                () ->  new ResourceNotFoundException( "Actor with ID : " + showActorId.toString() + " was not found!" ));

        foundActor.setActorShowName( nameToUpdate );

        // We will use JPARepository's save() method
        // If the ID is FOUND it will UPDATE the details
        // If the ID is NOT FOUND it will INSERT the details
        ShowActor updatedActor = actorRepository.save( foundActor );

        // Convert JPA Entity back to DTO using Mapper
        return actorMapper.convertToDTO( updatedActor );
    }

     */

    public void updateActorShowName( UUID idToUpdate, String updatedName ){
        int totalUpdatedRows = actorRepository.updateActorShowName( idToUpdate, updatedName );

        if( totalUpdatedRows == 0 )
            throw new ResourceNotFoundException( "Actor with ID : " + idToUpdate.toString() + " was not found!" );
    }

    @Override
    public void deleteActor(UUID idToDelete) {
        // First let's get the User by their ID and if not found we need to throw a ResourceNotFoundException
        ShowActor foundActor = actorRepository.findById( idToDelete ).orElseThrow(
                () ->  new ResourceNotFoundException( "Actor with ID : " + idToDelete.toString() + " was not found!" ));

        actorRepository.deleteById( idToDelete );
    }

}
