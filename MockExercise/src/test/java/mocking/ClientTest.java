package mocking;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ClientTest {

    Service mockService;
    Client spyClient;

    /**
     * This function is run before each test. We can use it to set up our mock objects with Mockito.
     */
    @BeforeEach
    public void setup() {
        // TODO: Mock the Service class here instead of calling new
        mockService = Mockito.mock(Service.class);
//        mockService = new Service();

        // TODO: Spy the Client class here instead of calling new
        spyClient = Mockito.spy(Client.class);
//        spyClient = new Client();

        // TODO: Use Mockito.when/thenReturn or Mockito.doReturn/when to tell the client
        //  to return the mock service when the factory method is called
        Mockito.doReturn(mockService).when(spyClient).serviceFactory();

    }

    /**
     * This is supposed to test whether the code in the Client is correct. The Client code is correct,
     *     but the Service has a bug that causes this test to fail. Using Mockito we can test the Client
     *     without also testing the Service
     */
    @Test
    public void testConvertValue() {
        String expected = "70";
        // TODO: Use Mockito.when/thenReturn or Mockito.doReturn/when to tell the service to return
        //  2 for input 35 when it's getDecimalDigitCount(int) method is called

        Mockito.doReturn(2).when(mockService).getDecimalDigitCount(35);

        String actual = spyClient.convertValue(35);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * This test has a problem similar to the last, but additionally we have no assurance
     *     that the Client's code is correct, since the function has no return value for us to
     *     check. However, we can use Mockito to check the parameters passed to the Service
     *     in order to see whether the Client has correct code.
     */
    @Test
    public void testCreateFormattedStringsWithAnswer() {

        // TODO: create a new Answer here (as an anonymous inner class) that checks the parameter
        //  passed into the mockService's processList(List<String>) method and asserts that the parameter is not null
       Answer a = new Answer() {
           @Override
           public Object answer(InvocationOnMock invocationOnMock) throws Throwable {

               Object argumentList = invocationOnMock.getArgument(0);
               Assertions.assertNotEquals(null, argumentList);

               return null;
           }
       };

       Mockito.doAnswer(a).when(mockService).processList(Mockito.anyList());
        // TODO: use Mockito.doAnswer to run your answer code whenever mockService.processList is called
        // Hint: Use Mockito.anyList() as the parameter to processList
        String input = "Have a nice day";
        spyClient.createFormattedStrings(input);

        // TODO: use Mockito.verify to ensure that mockService.processList is called
        Mockito.verify(mockService).processList(Mockito.anyList());
    }

}
