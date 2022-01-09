package com.arjun.design.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Proxies are also called surrogates, handles, and wrappers.
 */

public class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("nlm.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {

        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Access Denied to " + serverHost.toLowerCase());
        }
        internet.connectTo(serverHost);
    }
}
