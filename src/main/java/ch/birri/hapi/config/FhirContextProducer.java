package ch.birri.hapi.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


public class FhirContextProducer {

    @Inject
    HapiFhirConfig config;

    @ApplicationScoped
    public FhirContext fhirContext() {
        if(FhirVersionEnum.R4.equals(config.version)) {
            return FhirContext.forR4();
        } else if(FhirVersionEnum.R5.equals(config.version)) {
            return FhirContext.forR5();
        }
        throw new IllegalArgumentException("Unsupported FHIR version: " + config.version);
    }
}
