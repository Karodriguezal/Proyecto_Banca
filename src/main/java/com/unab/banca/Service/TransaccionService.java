package com.unab.banca.Service;

import com.unab.banca.Dao.ITransacionDao;
import com.unab.banca.Models.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaccionService {
    @Autowired
    private ITransacionDao iTransacionDao;

    @Transactional(readOnly=false)
    public Transaccion save(Transaccion transaccion) {

        return iTransacionDao.save(transaccion);
    }

    @Transactional(readOnly=false)
    public void delete(String id) {

        iTransacionDao.deleteById(id);
    }

    @Transactional(readOnly=true)
    public Transaccion findById(String id) {

        return iTransacionDao.findById(id).orElse(null);
    }

    @Transactional(readOnly=true)
    public List<Transaccion> findAll() {

        return (List<Transaccion>) iTransacionDao.findAll();
    }
    @Transactional(readOnly=true)
    public List<Transaccion> findByAll() {

    }

}
