package ch.birri.hapi.patient;

import ca.uhn.fhir.context.FhirContext;
import ch.birri.hapi.core.rest.BackendClient;
import ch.birri.hapi.core.service.FhirService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hl7.fhir.instance.model.api.IBaseResource;

@ApplicationScoped
public class PatientService implements FhirService {

    @Inject
    @RestClient
    BackendClient backendClient;

    @Inject
    FhirContext fhirContext;

    @Override
    public IBaseResource read(String id) {
        String patientString = backendClient.getPatientById(id);
        return fhirContext.newJsonParser().parseResource(patientString);
    }
}
