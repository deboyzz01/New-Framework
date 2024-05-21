package service.login.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginReqBody {
    private String userId;
    private String deviceId;
    private String osType;

    // optional body
    private String deviceInfo;
    private String osVersion;
    private Boolean jailbreakFlag;
    private String notificationSubscriberId;
    private String notificationToken;
    private Boolean isForceWeakUserId;
    private Boolean isFaceId;
    private boolean isMainLoginPage;
}


