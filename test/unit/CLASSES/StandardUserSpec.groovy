package CLASSES

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(StandardUser)
class StandardUserSpec extends Specification {

    def setup() {
        mockForConstraintsTests(StandardUser)
    }

    def cleanup() {
    }

    @Unroll("test StandardUser attribute gender: #gender, field: #field, valid: #valid ")
    def "Testing Domain Class StandardUser - gender"() {
        when:
        def t_Product_gender = new Product(gender: gender, birthday: '31/12/99', telephone: 34554433, points: 1)
        t_Product_gender.validate()

        then:
        t_Product_gender.errors.hasFieldErrors("gender") == false

        where:
        gender   | valid | field
        null     | false | 'null'
        'ok'     | false | 'algo'
        'male'   | true  | 'male'
        'female' | true  | 'female'
    }

}