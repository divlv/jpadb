package lv.div.jpadb.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class - Database table object for JPA
 */
@NamedQueries({

    @NamedQuery(name = "DemoData.list",
        query = "SELECT d FROM DemoData d WHERE d.id > :id ORDER by d.id"),

    @NamedQuery(name = "DemoData.delete",
        query = "DELETE FROM DemoData d WHERE d.id > 4")

})
@Entity
@Table(name = "demo_data")
public class DemoData {

    private Long id;

    @javax.persistence.Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long idUser) {
        this.id = idUser;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DemoData demoData = (DemoData) o;

        if (id != null ? !id.equals(demoData.id) : demoData.id != null) {
            return false;
        }
        if (name != null ? !name.equals(demoData.name) : demoData.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
