package vkMeeting.sdk;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.calls.responses.StartResponse;

public class AppVkSdk {
    private static final String TOKEN = "";
    public static final long USER_ID = ;

    public static void main(String[] args) throws ClientException, ApiException {
        String name = "name";
        String joinLink = createMeeting(name);
        System.out.println(joinLink);
    }

    private static String createMeeting(String name) throws ApiException, ClientException {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        UserActor userActor = new UserActor(USER_ID, TOKEN);
        StartResponse execute = vk.calls()
                .start(userActor)
                .unsafeParam("name", name)
                .execute();
        String joinLink = execute.getJoinLink();
        return joinLink;
    }
}
