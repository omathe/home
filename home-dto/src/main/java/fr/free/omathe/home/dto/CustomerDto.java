package fr.free.omathe.home.dto;

/**
 * Data Transfer Object of a customer.
 *
 * @author oma
 *
 */
public class CustomerDto extends Dto {

    private Long id;
    private String name;

    public CustomerDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerDto [id=" + id + ", name=" + name + "]";
    }

}
