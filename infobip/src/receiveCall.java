import java.awt.*;
import okhttp3.OkHttpClient;

public class receiveCall {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"text\":\"Test Voice message.\",\"language\":\"en\",\"voice\":{\"name\":\"Joanna\",\"gender\":\"female\"},\"from\":\"442032864231\",\"to\":\"41793026727\"}");
        Request request = new Request.Builder()
                .url("https://r5gdem.api.infobip.com/tts/3/single")
                .method("POST", body)
                .addHeader("Authorization", "{authorization}")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
    }
}
