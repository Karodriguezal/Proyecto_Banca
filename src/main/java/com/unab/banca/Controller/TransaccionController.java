package com.unab.banca.Controller;

import com.unab.banca.Dao.ITransacionDao;
import com.unab.banca.Models.Cuenta;
import com.unab.banca.Models.Transaccion;
import com.unab.banca.Service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cuenta")
public class TransaccionController {
    
    @Autowired
    private ITransacionDao iTransacionDao;

    @Autowired
    private TransaccionService transaccionService;
    
    @PostMapping(value="/")
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion transaccion){
        Transaccion obj = transaccionService.save(transaccion);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
    
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Transaccion> eliminar(@PathVariable String id){
        Transaccion obj = transaccionService.findById(id);
        if(obj!=null) 
            transaccionService.delete(id);
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion transaccion){
        Transaccion obj = transaccionService.findById(transaccion.getId_transaccion());
        if(obj!=null) {
            
            obj.setValor_transaccion(transaccion.getValor_transaccion());
            
            transaccionService.save(obj);
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<Transaccion> consultarTodo(){

        return transaccionService.findByAll();
    }
    
    @GetMapping("/list/{id}") 
    public Transaccion consultaPorId(@PathVariable String id){

        return transaccionService.findById(id);
    }
}
