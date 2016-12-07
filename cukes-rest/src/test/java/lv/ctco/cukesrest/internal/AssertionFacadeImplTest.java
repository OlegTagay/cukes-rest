package lv.ctco.cukesrest.internal;

import com.google.common.base.*;
import com.jayway.restassured.response.Response;
import lv.ctco.cukescore.internal.context.GlobalWorldFacade;
import org.junit.Test;

import static lv.ctco.cukesrest.CustomMatchers.equalToOptional;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class AssertionFacadeImplTest extends IntegrationTestBase {

    AssertionFacade facade = getInjector().getInstance(AssertionFacadeImpl.class);

    GlobalWorldFacade world = getInjector().getInstance(GlobalWorldFacade.class);

    @Test
    public void shouldNotInflateVarName() throws Exception {
        String headerName = "name";
        ResponseFacade mock = mock(ResponseFacade.class);
        Response response = mock(Response.class);
        when(response.getHeader(anyString())).thenReturn(headerName);
        when(mock.response()).thenReturn(response);
        ((AssertionFacadeImpl) facade).facade = mock;

        world.put("id", "1");
        facade.varAssignedFromHeader("{(id)}", headerName);
        Optional<String> value = world.get("id");
        assertThat(value, equalToOptional(headerName));
    }
}
