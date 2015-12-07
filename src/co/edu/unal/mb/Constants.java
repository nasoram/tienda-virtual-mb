package co.edu.unal.mb;

import com.google.api.server.spi.Constant;

public class Constants {
    public static final String WEB_CLIENT_ID = "879138721526-tf0r3mr9jmmeicckb8jcvri4gnajrc1k.apps.googleusercontent.com";
    public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
    public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
    public static final String EMAIL_SCOPE = Constant.API_EMAIL_SCOPE;
    public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;

    public static final String MEMCACHE_ANNOUNCEMENTS_KEY = "RECENT_ANNOUNCEMENTS";
}
