package lv.ctco.cukesrest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import lv.ctco.cukesrest.gadgets.GadgetResource;
import lv.ctco.cukesrest.healthcheck.CustomHeadersResource;
import lv.ctco.cukesrest.healthcheck.StaticTypesResource;

public class SampleApplication extends Service<SampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new SampleApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {
        bootstrap.setName("cukes-rest-sample-app");
    }

    @Override
    public void run(SampleConfiguration configuration, Environment environment) {
        Injector injector = Guice.createInjector();
        environment.addResource(injector.getInstance(GadgetResource.class));
        environment.addResource(injector.getInstance(StaticTypesResource.class));
        environment.addResource(injector.getInstance(CustomHeadersResource.class));
        environment.addHealthCheck(injector.getInstance(SampleHealthCheck.class));
    }
}
