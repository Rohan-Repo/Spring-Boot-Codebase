package in.easysystems.showcastdb.entity;

import jakarta.persistence.*;

import java.util.StringJoiner;
import java.util.UUID;

@Entity
@Table( name = "ShowCharacterActorNames" )
public class ShowActor {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    @Column( name = "actor_ID" )
    private UUID actorID;

    // An Actor should have a Show and a RealName - NOT NULL
    @Column( name = "show_name", nullable = false )
    private  String showName;

    // They could not have a Name on the show can be NULL
    @Column( name = "actor_show_name", nullable = true )
    private String actorShowName;

    @Column( name = "actor_real_name", nullable = false )
    private String actorRealName;

    public ShowActor() {
    }

    public ShowActor(UUID actorID, String showName, String actorShowName, String actorRealName) {
        this.actorID = actorID;
        this.showName = showName;
        this.actorShowName = actorShowName;
        this.actorRealName = actorRealName;
    }

    public UUID getActorID() {
        return actorID;
    }

    public void setActorID(UUID actorID) {
        this.actorID = actorID;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getActorShowName() {
        return actorShowName;
    }

    public void setActorShowName(String actorShowName) {
        this.actorShowName = actorShowName;
    }

    public String getActorRealName() {
        return actorRealName;
    }

    public void setActorRealName(String actorRealName) {
        this.actorRealName = actorRealName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShowActor.class.getSimpleName() + "[", "]")
                .add("actorID=" + actorID)
                .add("showName='" + showName + "'")
                .add("actorShowName='" + actorShowName + "'")
                .add("actorRealName='" + actorRealName + "'")
                .toString();
    }

}
