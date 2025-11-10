package in.easysystems.showcastdb.dto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public record RESTAPIResponse(
        int httpStatusCode,
        String responseStatus,
        String responseMessage,
        String timestamp
)
{
    public RESTAPIResponse( int httpStatusCode, String responseStatus, String responseMessage ){
        this(
                httpStatusCode, responseStatus, responseMessage,
                ZonedDateTime.now().format( DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss z") )
        );
}
}
