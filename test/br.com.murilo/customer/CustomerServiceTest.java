package br.com.murilo.customer;

import br.com.murilo.domain.Customer;
import br.com.murilo.exceptions.CustomerAlreadyExistsException;
import br.com.murilo.exceptions.CustomerNotFoundException;
import br.com.murilo.repository.CustomerRepository;
import br.com.murilo.repository.ICustomerRepository;
import br.com.murilo.usecases.CreateCustomerUseCase;
import br.com.murilo.usecases.FindCustomerByCpfUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerServiceTest {

    @Test
    public void whenNewCustomerInformedThenShouldBeCreated() throws CustomerAlreadyExistsException {

        ICustomerRepository repository = new CustomerRepository();
        CreateCustomerUseCase useCase = new CreateCustomerUseCase(repository);

        Customer customer = useCase.handle(new Customer(
                "Murilo",
                12345678910L,
                102030L,
                "End",
                12345,
                "Fortaleza",
                "CE"
        ));

        assertEquals("Murilo", customer.getName());
        assertEquals("Fortaleza", customer.getCity());
    }

    @Test
    public void whenExistingCustomerIsInformedThenAnExceptionShouldBeThrown() throws CustomerAlreadyExistsException {

        ICustomerRepository repository = new CustomerRepository();
        CreateCustomerUseCase useCase = new CreateCustomerUseCase(repository);

        useCase.handle(new Customer(
                "Murilo",
                12345678910L,
                102030L,
                "End",
                12345,
                "Fortaleza",
                "CE"
        ));

        assertThrows(CustomerAlreadyExistsException.class, () -> useCase.handle(
                new Customer(
                        "Murilo",
                        12345678910L,
                        102030L,
                        "End",
                        12345,
                        "Fortaleza",
                        "CE"
                ))
        );
    }

    @Test
    public void whenValidCpfIsGivenThenAnAuthorShouldBeReturned() throws CustomerNotFoundException, CustomerAlreadyExistsException {
        Customer customer = new Customer(
                "Murilo",
                12345678910L,
                102030L,
                "End",
                12345,
                "Fortaleza",
                "CE"
        );

        ICustomerRepository repository = new CustomerRepository();
        CreateCustomerUseCase createCustomerUseCase = new CreateCustomerUseCase(repository);
        FindCustomerByCpfUseCase findCustomerUseCase = new FindCustomerByCpfUseCase(repository);

        createCustomerUseCase.handle(customer);
        assertEquals(customer, findCustomerUseCase.handle(12345678910L));
    }

    @Test
    public void whenInvalidCpfIsGivenThenAnExceptionShouldBeThrown() {

        ICustomerRepository repository = new CustomerRepository();
        FindCustomerByCpfUseCase findCustomerUseCase = new FindCustomerByCpfUseCase(repository);

        assertThrows(CustomerNotFoundException.class, () -> findCustomerUseCase.handle(12345678910L));
    }
}