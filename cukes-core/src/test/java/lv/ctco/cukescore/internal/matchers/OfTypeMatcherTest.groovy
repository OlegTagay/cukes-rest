package lv.ctco.cukescore.internal.matchers

import lv.ctco.cukescore.RequestBody
import org.junit.Ignore
import org.junit.Test

import static lv.ctco.cukescore.internal.matchers.JsonMatchers.containsValueByPath
import static lv.ctco.cukescore.internal.matchers.OfTypeMatcher.ofType
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsNot.not

public class OfTypeMatcherTest {

    public static final String JSON = "application/json"
    public static final String XML = "application/xml"

    @Test
    public void "json object returned is Integer"() throws Exception {
        def content = '{"value": 1}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("integer")))
    }

    @Test
    public void "json object returned is Long"() throws Exception {
        def content = '{"value": 12345678987}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("long")))
    }

    @Test
    public void "json object returned is String"() throws Exception {
        def content = '{"value": "test"}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("string")))
    }

    @Test
    public void "json object returned is Float"() throws Exception {
        def content = '{"value": 1.1}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("float")))
    }

    @Test
    public void "json object returned is Boolean"() throws Exception {
        def content = '{"value": true}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("boolean")))
    }

    @Test
    public void "json object returned is List"() throws Exception {
        def content = '{"value": [1,2]}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("list")))
    }

    @Test
    public void "json object returned is Map"() throws Exception {
        def content = '{"value": {"test": 1, "another": 2}}'
        assertThat(new RequestBody(JSON, content), containsValueByPath("value", ofType("map")))
    }

    @Test
    public void "json value type doesn't match"() throws Exception {
        def content = '{"value": 1}'
        assertThat(new RequestBody(JSON, content), not(containsValueByPath("value", ofType("float"))))
    }

    @Test
    public void "xml object returned is String"() throws Exception {
        def content = '<value>1</value>'
        assertThat(new RequestBody(XML, content), containsValueByPath("value", ofType("string")))
    }

    @Test
    @Ignore
    // How to Handle XML?
    public void "xml object returned is Map"() throws Exception {
        def content = '<value><test>1</test><another>2</another></value>'
        assertThat(new RequestBody(XML, content), containsValueByPath("value", ofType("map")))
    }
}
