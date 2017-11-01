package org.rainboweleven.platform.domain.pm;

import org.rainboweleven.platform.domain.pm.Version;
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
    Git git;
}
