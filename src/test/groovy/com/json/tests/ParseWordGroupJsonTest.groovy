package com.json.tests

import com.fasterxml.jackson.databind.ObjectMapper
import com.langpath.app.model.storage.WordGroup
import spock.lang.Specification

/**
 * Created by root on 20.10.16.
 */
class ParseWordGroupJsonTest extends Specification {

    def "Should parse JSON to WordGroup object"() {
        given:
        def input = """{"name":"d","description":"d","words":[{"value":"sd","meaning":"sd"},{},{}],"sourceLang":{"id":1,"label":"English"},"targetLang":{"id":1,"label":"English"}}"""
        ObjectMapper mapper = new ObjectMapper();
        when:
        WordGroup wordGroup =  mapper.readValue(input, WordGroup.class);
        then:
        wordGroup.getName() == "d";
    }

    def "Should print color hex"() {
        when:
        Random r = new Random()
        then:
        println String.format("#%02x%02x%02x", r.nextInt(256), r.nextInt(256), r.nextInt(256))
    }
}
