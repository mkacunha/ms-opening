package br.com.gft.wa.manager.domain.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Employee {

    public static final int STAFF = 1;

    public static final int MANAGER = 2;

    public static final int EMPLOYEE = 3;

    @Id
    @Column(name = "id_fun")
    private Long id;

    @Column(name = "tipo")
    private int type;

    @Column(name = "nome")
    private String name;

    public String getName() {
        return name;
    }
}
