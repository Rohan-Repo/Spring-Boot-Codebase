package in.easysystems.showcastdb.controller;

import in.easysystems.showcastdb.dto.ActorDetailsDTO;
import in.easysystems.showcastdb.dto.ActorShowNameUpdateDTO;
import in.easysystems.showcastdb.dto.RESTAPIResponse;
import in.easysystems.showcastdb.dto.ShowActorDTO;
import in.easysystems.showcastdb.service.ShowActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(
            summary = "Add a new actor to the database",
            description = "Creates a new cast member entry with details including show name, character name, and real name, actorID generated automatically."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Actor successfully created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            )
    })
    public ResponseEntity<RESTAPIResponse> createActor(
            @Parameter(description = "Details of the actor to create", required = true)
            @RequestBody ShowActorDTO showActorDTO){
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
    @Operation(
            summary = "Retrieve actor details by unique ID",
            description = "Fetches the full profile of a TV show actor, including character and real name, using their unique actor identifier."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ShowActorDTO.class)
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Bad request - invalid input or parameters",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Actor ID not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            )
    })
    public ResponseEntity<ShowActorDTO> getActorById(
            @Parameter(description = "Unique identifier (UUID) of the actor", required = true)
            @PathVariable("id") UUID idToSearch ){
        ShowActorDTO actorDTO = actorService.getActorById( idToSearch );
        return ResponseEntity.ok( actorDTO );
    }

    // Read: How to retrieve all actor data from a table. - SQL Keywords: SELECT
    // @GetMapping to handle HTTP GET Requests
    @GetMapping( "/")
    @Operation(
            summary = "List all actors in the database",
            description = "Returns a collection of all TV show cast members and their roles currently available in the database."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful retrieval of all actors",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema( schema = @Schema(implementation = ShowActorDTO.class) )
                    )
            )
    })
    public ResponseEntity< List<ShowActorDTO> > getAllActors(){
        List<ShowActorDTO> allActors = actorService.getAllActors();
        return ResponseEntity.ok( allActors );
    }

    // HTTP PUT Method will be used here because we are updating the entire object properties
    // Update: How to modify existing records. SQL Keywords: UPDATE
    @PutMapping("/{id}")
    @Operation(
            summary = "Update actor information",
            description = "Modifies all details of a specified cast member by their actor ID; input should include the complete actor object."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Actor ID not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            )
    })
    public ResponseEntity<RESTAPIResponse> updateActor(
            @Parameter(description = "Unique identifier (UUID) of the actor to update", required = true)
            @PathVariable("id") UUID idToSearch,
            @Parameter(description = "The newDetails of the actor to update", required = true)
            @RequestBody ShowActorDTO showActorDTO) {

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
    @Operation(
            summary = "Update the actor’s character name",
            description = "Updates an actor’s role name for a specific cast member using their actor ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Actor ID not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            )
    })
    public ResponseEntity<RESTAPIResponse> updateActorShowName(
            @Parameter(description = "Unique identifier (UUID) of the actor to update", required = true)
            @PathVariable UUID id,
            @Parameter(description = "The newActorShowName of the actor to update", required = true)
            @RequestBody ActorShowNameUpdateDTO nameUpdateDTO) {
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
    @Operation(
            summary = "Remove an actor from the database",
            description = "Deletes a cast member’s record and all associated data using their unique actor ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Actor ID not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RESTAPIResponse.class)
                    )
            )
    })
    public ResponseEntity<RESTAPIResponse> deleteActor(
            @Parameter(description = "Unique identifier (UUID) of the actor to delete", required = true)
            @PathVariable("id") UUID idToDelete ) {

        actorService.deleteActor( idToDelete );

        RESTAPIResponse response = new RESTAPIResponse(
                HttpStatus.OK.value(),
                "ACTOR DELETED",
                "Actor has been successfully DELETED."
        );

        return ResponseEntity.status( HttpStatus.OK ).body( response );
    }

    @Operation(
            summary = "List all actors in the database without ID",
            description = "Returns a collection of all TV show cast members and their roles currently available in the database besides the actorId field."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful retrieval of actor data",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema( schema = @Schema(implementation = ActorDetailsDTO.class) )
                    )
            )
    })
    @GetMapping( "/details")
    public ResponseEntity<List<ActorDetailsDTO>> getActorDetails(){
        List<ActorDetailsDTO> actorDetailsWithoutId = actorService.getActorDetailsWithoutId();
        return ResponseEntity.ok( actorDetailsWithoutId );
    }
}
