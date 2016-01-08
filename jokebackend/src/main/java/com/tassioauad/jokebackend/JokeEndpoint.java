/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.tassioauad.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.tassioauad.jokelib.Joker;

@Api(
    name = "jokeApi",
    version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "backend.gradle.udacity.com",
            ownerName = "backend.gradle.udacity.com",
            packagePath = ""
    )
)
public class JokeEndpoint {
    @ApiMethod(name = "joke")
    public Joker joke() {
        return new Joker();
    }

}
