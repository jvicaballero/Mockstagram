package com.example.mockstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        // Add your initialization code here

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("gsgH75Na5ROWbmJ1NxfX5AqqSOtlWAgq3j6ryQP0")
                .clientKey("ATNfzWjFVbyjbMqIymo5dDbkl5hy0WphyJKh2F63")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
