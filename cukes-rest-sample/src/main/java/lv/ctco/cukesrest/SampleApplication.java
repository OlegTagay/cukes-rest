package lv.ctco.cukescore;

import com.google.inject.*;
import com.yammer.dropwizard.*;
import com.yammer.dropwizard.config.*;
import lv.ctco.cukescore.gadgets.*;
import lv.ctco.cukescore.healthcheck.*;

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
