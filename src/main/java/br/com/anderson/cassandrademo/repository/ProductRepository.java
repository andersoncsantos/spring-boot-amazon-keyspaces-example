package br.com.anderson.cassandrademo.repository;

import br.com.anderson.cassandrademo.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Integer> {
}
