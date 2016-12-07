package lv.ctco.cukescore;

/**
 * List of variables and options used in cukes-core.
 */
public interface CukesOptions {
    int CUKES_BEFORE_HOOK_STARTUP_ORDER = 500;
    String PROPERTIES_PREFIX = "cukes.";
    String HEADER_PREFIX = "header.";
    String DELIMITER = ",";

    String RESOURCES_ROOT = "resources_root";
    String BASE_URI = "base_uri";
    String PLUGINS = "plugins";
    String PROXY = "proxy";
    String AUTH_TYPE = "auth_type";
    String USERNAME = "username";
    String PASSWORD = "password";

    String URL_ENCODING_ENABLED = "url_encoding_enabled";
    String RELAXED_HTTPS = "relaxed_https";
    String CONTEXT_INFLATING_ENABLED = "context_inflating_enabled";
    String ASSERTIONS_DISABLED = "assertions_disabled";

    String LOADRUNNER_FILTER_BLOCKS_REQUESTS = "loadrunner_filter_blocks_requests";
}
