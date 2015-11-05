package CLASSES

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Product)
    }

    def cleanup() {
    }
    @Unroll ("test Product attribute name: #name, field: #field, valid: #valid ")
    def "Testing Domain Class Product - name"() {
        when:
        def t_Product_name = new Product(name: name, description: 'esto es un test')
        t_Product_name.validate()

        then:
        t_Product_name.errors.hasFieldErrors("name") == false

        where:
        name | valid | field
        null | false | 'null'
        'ok' | true | 'algo'
    }
    @Unroll ("test Product attribute description: #description, field: #field, valid: #valid ")
    def "Testing Domain Class Product - description"() {
        when:
        def t_Product_description = new Product(name: 'esto es un test', description: description)
        t_Product_description.validate()

        then:
        t_Product_description.errors.hasFieldErrors("description") == false

        where:
        description | valid | field
        null | false | 'null'
        'ok' | true | 'algo'
        '1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890'|false|'maxRange'

    }
}
