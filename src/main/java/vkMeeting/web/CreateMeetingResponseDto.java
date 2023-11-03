package vkMeeting.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMeetingResponseDto implements Serializable {

    @JsonProperty("response")
    private ResponseDto responseDto;

    @Builder
    @Jacksonized
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDto implements Serializable {

        @JsonProperty("join_link")
        private String join_link;

    }
}