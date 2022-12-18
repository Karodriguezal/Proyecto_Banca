package com.unab.banca.Service;
import com.unab.banca.Dao.IAdministradorDao;
import com.unab.banca.Models.Administrador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AdministradorService {
    @Autowired
    private IAdministradorDao iAdministradorDao;
    
    @Transactional(readOnly=false)
    public Administrador save(Administrador administrador) {

        return iAdministradorDao.save(administrador);
    }
    @Transactional(readOnly=false)
    public void delete(String id) {
        iAdministradorDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Administrador findById(String id) {

        return iAdministradorDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Administrador> findByAll() {

        return (List<Administrador>) iAdministradorDao.findAll();
    }

}
