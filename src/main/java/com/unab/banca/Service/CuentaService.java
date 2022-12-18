package com.unab.banca.Service;
import com.unab.banca.Models.Cuenta;
import com.unab.banca.Dao.ICuentaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaService {
    @Autowired
    private ICuentaDao iCuentaDao;
    
    @Transactional(readOnly=false)
    public Cuenta save(Cuenta cuenta) {

        return iCuentaDao.save(cuenta);
    }
    @Transactional(readOnly=false)
    public void delete(String id) {
        iCuentaDao.deleteById(id);;
    }
    @Transactional(readOnly=true)
    public Cuenta findById(String id) {

        return iCuentaDao.findById(id).orElse(null);
    }
    @Transactional(readOnly=true)
    public List<Cuenta> findByAll() {

        return (List<Cuenta>) iCuentaDao.findAll();
    }

}
