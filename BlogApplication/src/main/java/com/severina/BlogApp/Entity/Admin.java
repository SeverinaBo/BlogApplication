package com.severina.BlogApp.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Admin implements Serializable {
    @Id
    @Column(length = 5)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Admin admin1 = (Admin) o;

        return id.equals(admin1.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
