package common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {

	public static final char CSV_SEPARATOR = ',';
	public static final String BASE_DIR = "src/test/resources/";
	
	public static final String PROPERTY_BASE_URL = "webdriver.base.url";
//	public static final String BASE_URL = "https://www.60beans.com";
//	public static final String BASE_URL = "https://staging.www.60beans.com";

	public static final List<String> COLLECTIONS_URLS = Collections.unmodifiableList(Arrays.asList(
			"/collections/deals",
			"/collections/kaffee"));

	public static final List<String> PDP_URLS = Collections.unmodifiableList(Arrays.asList(
			"/products/seruni-flores-bajawa-espresso",
			"/products/roeststaette-alto-da-serra-espresso"));
}
