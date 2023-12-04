import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.registerServlet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class registerServletTest {

    @Test
    void testDoPostWithValidParameters() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("email")).thenReturn("myTestEmail@gmail.com");
        Mockito.when(request.getParameter("password")).thenReturn("mySecretPassword");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            Mockito.when(response.getWriter()).thenReturn(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        registerServlet servlet = new registerServlet();

        assertDoesNotThrow(() -> servlet.doPost(request, response));
    }

    @Test
    void testDoPostWithInvalidParameters() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Set parameters to null to simulate invalid parameters
        Mockito.when(request.getParameter("email")).thenReturn(null);
        Mockito.when(request.getParameter("password")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            Mockito.when(response.getWriter()).thenReturn(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        registerServlet servlet = new registerServlet();

        assertDoesNotThrow(() -> servlet.doPost(request, response));
    }
}
