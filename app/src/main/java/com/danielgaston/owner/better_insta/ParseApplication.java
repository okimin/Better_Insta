package com.danielgaston.owner.better_insta;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("uG6kqfEIhOpzMdJODmU6Mmg7PPEhqfxW2iuN3MsP")
                .clientKey("YxWG0VbPfGxbwKp9WZeedVnHHTBNlFrhtvDtIPpH")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
