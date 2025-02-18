package ch.birri.hapi.core.service;

import org.hl7.fhir.instance.model.api.IBaseResource;

public interface FhirService {

    IBaseResource read(String id);
}
