package fit.iuh.edu.vn.services;

import fit.iuh.edu.vn.entities.Address;
import fit.iuh.edu.vn.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AdressService {
    @Autowired
    private AddressRepository candidateRepository;

    public Page<Address> findAll(int pageNo, int pageSize, String sortBy,
                                 String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }
}