import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.Notifier
import spock.lang.Specification

class FirstSpecification extends Specification{
    def "distinct_bug_8726"(){
        given:
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
        when:
            def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
            result == Arrays.asList(1,2,4)
    }
    def "Should verify notify was called"() {
        given:
        def notifier = Mock(Notifier)
        when:
        notifier.notify('foo')
        then:
        1 * notifier.notify('foo')
    }

}
