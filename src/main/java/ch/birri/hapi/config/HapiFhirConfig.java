package ch.birri.hapi.config;

import ca.uhn.fhir.context.FhirVersionEnum;
import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "hapi.fhir")
public class HapiFhirConfig {
    FhirVersionEnum version;
}
