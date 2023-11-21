package org.example.server;


import jakarta.jws.WebService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebService(endpointInterface = "org.example.server.PersonService")
public class PersonServiceImpl implements PersonService {
    private static Map persons = new HashMap();

    @Override
    public boolean addPerson(Person p) {
        if(persons.get(p.getId()) != null) return false;
        persons.put(p.getId(), p);
        return true;
    }

    @Override
    public boolean deletePerson(int id) {
        if(persons.get(id) == null) return false;
        persons.remove(id);
        return true;
    }

    @Override
    public Person getPerson(int id) {
        return (Person) persons.get(id);
    }

    @Override
    public Person[] getAllPersons() {
        Set ids = persons.keySet();
        Person[] p = new Person[ids.size()];
        int i=0;
        for(Object id : ids){
            p[i] = (Person) persons.get(id);
            i++;
        }
        return p;
    }
}
