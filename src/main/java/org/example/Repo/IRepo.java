package org.example.Repo;


import java.util.List;

public interface IRepo<T, ID> {

    List<T> getAll();

    T findById(ID id);



}
