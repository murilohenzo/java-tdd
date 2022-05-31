package br.com.murilo.repository;

import br.com.murilo.domain.Customer;

public interface ICustomerRepository {
    Customer save(Customer customer);
    Customer findByCpf(long cpf);
}
