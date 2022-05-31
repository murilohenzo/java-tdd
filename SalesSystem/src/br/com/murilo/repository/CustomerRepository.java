package br.com.murilo.repository;

import br.com.murilo.domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerRepository implements ICustomerRepository{
    private final Map<Integer, Customer> customers = new HashMap<>();

    @Override
    public Customer save(Customer customer) {
        int id = this.customers.size() + 1;

        this.customers.put(id, customer);
        return customer;
    }

    @Override
    public Customer findByCpf(long cpf) {
        return  this.customers.values()
                .stream().filter(customer -> Objects.equals(cpf, customer.getCpf()))
                .findAny().orElse(null);
    }
}
