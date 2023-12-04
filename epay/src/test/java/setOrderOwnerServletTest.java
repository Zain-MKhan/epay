import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.setOrderOwnerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class setOrderOwnerServletTest {

    @Test
    void testDoPostWithValidParameters() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        Mockito.when(request.getParameter("orderid")).thenReturn("123");
        Mockito.when(request.getParameter("email")).thenReturn("testEmail@gmail.com");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            Mockito.when(response.getWriter()).thenReturn(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setOrderOwnerServlet servlet = new setOrderOwnerServlet();

        assertDoesNotThrow(() -> servlet.doPost(request, response));
    }

    @Test
    void testDoPostWithInvalidParameters() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        // Set parameters to null to simulate invalid parameters
        Mockito.when(request.getParameter("orderid")).thenReturn(null);
        Mockito.when(request.getParameter("email")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        try {
            Mockito.when(response.getWriter()).thenReturn(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setOrderOwnerServlet servlet = new setOrderOwnerServlet();

        assertDoesNotThrow(() -> servlet.doPost(request, response));
    }
}
