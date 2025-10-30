package in.easysystems.showcastdb.controller;

import in.easysystems.showcastdb.dto.ActorShowNameUpdateDTO;
import in.easysystems.showcastdb.dto.RESTAPIResponse;
import in.easysystems.showcastdb.dto.ShowActorDTO;
import in.easysystems.showcastdb.service.ShowActorService;
import in.easysystems.showcastdb.service.impl.ShowActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// @RestController lets the Application create a REST API to perform CRUD operations
// The REST API used for CRUD operations - Create / Read / Update / Delete
@RestController

// Set the Base URL for all REST API end points
@RequestMapping("/api/showactors")
public class ShowActorController {


    // Injecting Interface ShowActorService instead of ShowActorServiceImpl so if required we should eb able to swap the implementation at a later stage
    private final ShowActorService actorService;

    // Since we just have one value so we do not need the @Autowired cause SpringBoot will automatically inject it for us
    // For Single Element Constructor Spring ICO Container will inject this dependency by default
    public ShowActorController(ShowActorService actorService) {
        this.actorService = actorService;
    }

    //  Create: How to create a new actor record in a table - SQL Keywords: INSERT
    // INSERTION should be a Post operation so @@PostMapping to handle HTTP POST Requests
    // @RequestBody converts the JSON Object to Java Object
    @PostMapping("/")
    public ResponseEntity<RESTAPIResponse> createActor(@RequestBody ShowActorDTO showActorDTO){
        ShowActorDTO savedActorDTO = actorService.createActor(showActorDTO);

        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.CREATED.value(),
                "ACTOR CREATED",
                "Actor has been successfully created."
                );

        return ResponseEntity.status( HttpStatus.CREATED ).body( response );
    }

    // Read: How to retrieve specific actor from a table. - SQL Keywords: SELECT
    // @GetMapping to handle HTTP GET Requests
    @GetMapping( "/{id}")
    // Since "id" and idToSearch are different we have to specify otherwise change idToSearch to id
    public ResponseEntity<ShowActorDTO> getActorById(@PathVariable("id") UUID idToSearch ){
        ShowActorDTO actorDTO = actorService.getActorById( idToSearch );
        return ResponseEntity.ok( actorDTO );
    }

    // Read: How to retrieve all actor data from a table. - SQL Keywords: SELECT
    // @GetMapping to handle HTTP GET Requests
    @GetMapping( "/")
    public ResponseEntity< List<ShowActorDTO> > getAllActors(){
        List<ShowActorDTO> allActors = actorService.getAllActors();
        return ResponseEntity.ok( allActors );
    }

    // HTTP PUT Method will be used here because we are updating the entire object properties
    // Update: How to modify existing records. SQL Keywords: UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<RESTAPIResponse> updateActor( @PathVariable("id") UUID idToSearch, @RequestBody ShowActorDTO showActorDTO) {

        actorService.updateActor( idToSearch, showActorDTO );

        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.OK.value(),
                "ACTOR UPDATED",
                "Actor has been successfully updated."
        );

        return ResponseEntity.status( HttpStatus.OK ).body( response );
    }

    // Update: How to modify existing records. SQL Keywords: UPDATE
    // HTTP PATCH Method will be used here because we are updating the actorShowName and NOT the entire object
    @PatchMapping("/{id}")
    public ResponseEntity<RESTAPIResponse> updateActorShowName(@PathVariable UUID id, @RequestBody ActorShowNameUpdateDTO nameUpdateDTO) {
        actorService.updateActorShowName( id, nameUpdateDTO.actorShowName() );

        // If Update was unsuccessful we have handled the 404 Error in our Service class if it returns here then it means it was successful

        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.OK.value(),
                "ACTOR UPDATED",
                "Actor has been successfully updated."
        );

        return ResponseEntity.status( HttpStatus.OK ).body( response );
    }

    // Delete: How to remove records from a table. SQL Keywords: DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<RESTAPIResponse> deleteActor( @PathVariable("id") UUID idToDelete ) {

        actorService.deleteActor( idToDelete );

        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.OK.value(),
                "ACTOR DELETED",
                "Actor has been successfully DELETED."
        );

        return ResponseEntity.status( HttpStatus.OK ).body( response );
    }
}
