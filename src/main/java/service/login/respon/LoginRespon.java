package service.login.respon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRespon {

    private String timestamp;
    private String traceId;
    private String sourceSystem;
    private String responseKey;
    private Message message;
    private DataObject data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Message{
        private String titleIdn;
        private String titleEng;
        private String descIdn;
        private String descEng;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    class DataObject {
        private String nickname;
        private String customerSegmentation;
        private String menu;
        private String bankedStatus;
        private String mobilePhone;
        private String lastLoginDate;
        private boolean suggestKycbanner;
        private String cdpKey;
        private boolean supplement;
        private String cdpKey2;
    }

}
