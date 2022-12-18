package com.unab.banca.Service;
import com.unab.banca.Dao.IClienteDao;
import com.unab.banca.Models.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private IClienteDao iClienteDao;

    @Transactional(readOnly=false)
    public Cliente save(Cliente cliente) {

        return iClienteDao.save(cliente);
    }

    @Transactional(readOnly=false)
    public void delete(String id) {

        iClienteDao.deleteById(id);
    }

    @Transactional(readOnly=true)
    public Cliente findById(String id) {

        return iClienteDao.findById(id).orElse(null);
    }

    @Transactional(readOnly=true)
    public List<Cliente> findAll() {

        return (List<Cliente>) iClienteDao.findAll();
    }

}
