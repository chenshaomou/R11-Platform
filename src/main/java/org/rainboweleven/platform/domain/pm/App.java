package org.rainboweleven.platform.domain.pm;

import java.util.Set;

//应用
public class App {

    String name;
    String id;
    String key;
    String secret;
    String description;
    String evn;
    Set<Version> version;
    Version current;
    GitRepository git;
}
