package ch.birri.hapi.core.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "backend-api")
public interface BackendClient {

    @GET
    @Path("/Patient/{id}")
    String getPatientById(@PathParam("id") String id);
}
