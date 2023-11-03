package vkMeeting.web;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

public class AppVkWebClient {

    private static final String TOKEN = "";

    public static final String OAUTH_PATH = "https://api.vk.com/method";

    public static void main(String[] args) {
        String name = "name";
        String joinLink = createMeeting(name);
        System.out.println(joinLink);
    }

    private static String createMeeting(String name) {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        WebClient client = WebClient.builder()
                .baseUrl(OAUTH_PATH)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        CreateMeetingResponseDto dto = client
                .post()
                .uri(uriBuilder ->
                        uriBuilder.path("/calls.start")
                                .queryParam("name", name)
                                .queryParam("v", "5.154")
                                .build()
                )
                .header("Authorization", "Bearer " + TOKEN)
                .retrieve()
                .bodyToMono(CreateMeetingResponseDto.class)
                .block();
        String joinLink = dto.getResponseDto().getJoin_link();
        return joinLink;
    }
}
