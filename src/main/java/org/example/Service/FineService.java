package org.example.Service;







import org.example.Modell.Fine;


import org.example.Repo.IRepo;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FineService {
    private final IRepo<Fine, Integer> FineRepo;

    public FineService(IRepo<Fine, Integer> FineRepo) {
        this.FineRepo = FineRepo;
    }

    public List<Fine> getAllFine() throws IOException {
        return FineRepo.getAll();
    }

    public Fine getFine(Integer id) throws IOException {
        return FineRepo.findById(id);
    }
}
