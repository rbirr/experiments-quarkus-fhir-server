package ch.birri.hapi.patient;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;

@ApplicationScoped
public class PatientProvider implements IResourceProvider {
    @Inject
    PatientService patientService;;

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient read(@IdParam IdType theId) {
        return (Patient) patientService.read(theId.getIdPart());
    }
}
