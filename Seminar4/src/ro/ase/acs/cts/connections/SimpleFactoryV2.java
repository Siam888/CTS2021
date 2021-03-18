package ro.ase.acs.cts.connections;

public class SimpleFactoryV2 {

    private final static String DEVELOPMENT = "development";
    private final static String RELEASE = "release";

    public static RestServiceV2 createConnection(String type, String url) {
        if (DEVELOPMENT.equals(type)) {
            return new RestApiDevelopmentV2(url);
        } else if (RELEASE.equals(type)) {
            return new RestApiReleaseV2(url);
        } else {
            return null;
        }
    }
}
