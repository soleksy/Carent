package app.dao;

import app.entity.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CarEntity getCar(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CarEntity.class, id);
    }

    @Override
    public List<CarEntity> getCars() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CarEntity ", CarEntity.class).list();
    }

    @Override
    public void saveCar(CarEntity car) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(car);

    }

    @Override
    public void deleteCar(CarEntity car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }
}
