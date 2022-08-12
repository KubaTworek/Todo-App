package pl.jakubtworek.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jakubtworek.springdemo.entity.Todo;

import java.util.List;

@Repository
public class TodoDAOImpl implements TodoDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Todo> getTodos() {
        Session currentSession = sessionFactory.openSession();
        Query<Todo> theQuery = currentSession.createQuery("from Todo", Todo.class);
        List<Todo> todos = theQuery.getResultList();
        return todos;
    }

    @Override
    public Todo getTodo(int theId) {
        Session currentSession = sessionFactory.openSession();
        Todo theTodo = currentSession.get(Todo.class, theId);
        return theTodo;
    }

    @Override
    public void saveTodo(Todo theTodo) {
        Session currentSession = sessionFactory.getCurrentSession();
        System.out.println(theTodo.getId());
        currentSession.saveOrUpdate(theTodo);
        System.out.println(theTodo.getId());
    }

    @Override
    public void deleteTodo(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query theQuery = currentSession.createQuery("delete from Todo where id=:todoId");
        theQuery.setParameter("todoId", theId);

        theQuery.executeUpdate();
    }
}
