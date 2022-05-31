package br.com.murilo.usecases;

import br.com.murilo.domain.Customer;
import br.com.murilo.exceptions.CustomerNotFoundException;
import br.com.murilo.repository.ICustomerRepository;

public class FindCustomerByCpfUseCase {
    private final ICustomerRepository iCustomerRepository;

    public FindCustomerByCpfUseCase(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    public Customer handle(long cpf) throws CustomerNotFoundException {
        Customer existsCustomer = this.iCustomerRepository.findByCpf(cpf);
        try {
            if (existsCustomer != null) {
                return existsCustomer;
            }
            throw new CustomerNotFoundException("Customer not found in database");
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException("Customer not found in database");
        }
    }
}
