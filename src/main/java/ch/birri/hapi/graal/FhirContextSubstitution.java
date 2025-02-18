package ch.birri.hapi.graal;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(FhirContext.class)
final class FhirContextSubstitution {
    @Substitute
    public IParser newRDFParser() {
        throw new UnsupportedOperationException();
    }
}
