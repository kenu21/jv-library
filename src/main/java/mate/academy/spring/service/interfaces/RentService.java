package mate.academy.spring.service.interfaces;

import java.util.List;

import mate.academy.spring.entity.Rent;

public interface RentService {
    void add(Rent rent);

    List<Rent> listRents();
}
