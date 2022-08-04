package org.example;

import models.Actor;
import models.Character;
import models.Network;
import models.Show;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Actor actor = new Actor("Brad", "Pitt");
        Network network = new Network("call letter", 5);
        Show show = new Show("Vinland Saga", "Monday", "Fall", "Vikings", network);
        Character character = new Character("Thorfin", "You're dead!", actor, show);

        actor.setCharacter(List.of(character));
        show.setCharacters(List.of(character));
        network.setShows(List.of(show));

        entityManager.persist(actor);
        entityManager.persist(show);
        entityManager.persist(network);
        entityManager.persist(character);

        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}