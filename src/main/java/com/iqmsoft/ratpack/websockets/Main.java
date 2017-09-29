package com.iqmsoft.ratpack.websockets;

import ratpack.rx.RxRatpack;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;


public class Main {

    
    public static void main(String... args) throws Exception {
        RxRatpack.initialize();

        RatpackServer.start(
                s -> s.serverConfig(
                        c -> c.baseDir(BaseDir.find()))
                                    .registryOf(registry -> {
                                        registry.add(new ChatHandler());
                                    })
                                    .handlers(chain ->
                                            chain
                                                .get("chat", ChatHandler.class)
                                                .files(f -> f.dir("public").indexFiles("index.html"))));
    }
}
