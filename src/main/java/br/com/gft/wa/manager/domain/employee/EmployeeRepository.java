package br.com.gft.wa.manager.domain.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByIdAndType(Long id, int type);

    default Employee getOne(Long id) {
        return findById(id).orElseThrow(() -> new RuntimeException("Funcionário de id " + id + " não encontrato"));
    }

}
