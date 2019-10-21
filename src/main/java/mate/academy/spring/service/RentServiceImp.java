package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.dao.interfaces.RentDao;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.service.interfaces.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImp implements RentService {

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void add(Rent rent) {
        rentDao.add(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> listRents() {
        return rentDao.listRents();
    }
}
