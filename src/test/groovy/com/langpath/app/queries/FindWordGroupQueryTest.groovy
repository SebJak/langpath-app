package com.langpath.app.queries

import com.langpath.app.model.query.RequestObjectId
import com.langpath.app.model.response.WordGroupInfo
import org.bson.types.ObjectId
import spock.lang.Specification

/**
 * Created by root on 21.10.16.
 */
class FindWordGroupQueryTest extends Specification {

    def query = new FindUserWordGroupQuery();

    def "FindWordGroupById"() {
        when:
        def request = new RequestObjectId()
        request.id = new ObjectId("58093966112f5a1dd40fcbb7")
        WordGroupInfo view = query.findWordGroupById(request)
        then:
        view.name == "d"
    }
}
