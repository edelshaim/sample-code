// Install the Java helper library from twilio.com/docs/java/install

import com.twilio.Twilio;
import com.twilio.rest.notify.v1.service.Notification;

import java.util.Arrays;
import java.util.HashMap;

public class Example {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Notification notification = 
            Notification.creator("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
            .setApn(
                new HashMap<String, Object>()
                {{
                    put("aps", new HashMap<String, Object>()
                    {{
                        put("alert", new HashMap<String, Object>()
                        {{
                            put("title", "Bob alert");
                            put("body", "Bob, you just received a badge");
                        }});
                        put("badge", 1);
                    }});
                }})
            .setIdentity(Arrays.asList("00000001"))
            .create();

        System.out.println(notification.getSid());
    }
}