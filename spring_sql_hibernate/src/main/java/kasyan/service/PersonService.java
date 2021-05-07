package kasyan.service;

import kasyan.bean.Person;
import kasyan.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService{

    // проверка на совпадение login и password
    public boolean verificationOfAuthenticity(String login, String password){
        List<Person> personList = findAllPerson();
        for (Person person : personList) {
            if (login.equals(person.getLogin()) && password.equals(person.getPassword())) return true;
        }
        return false;
    }

    // отправка запроса на получение всех пользователей их БД
    public List<Person> findAllPerson(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Person> persons = session.createQuery("FROM Person").getResultList();
        session.close();
        return persons;
    }
}