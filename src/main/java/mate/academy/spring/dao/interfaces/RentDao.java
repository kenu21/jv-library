package mate.academy.spring.dao.interfaces;

import java.util.List;

import mate.academy.spring.entity.Rent;

public interface RentDao {
    void add(Rent rent);

    List<Rent> listRents();
}
