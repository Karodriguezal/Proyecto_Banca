package com.unab.banca.Controller;

import com.unab.banca.Dao.IAdministradorDao;
import com.unab.banca.Models.Cliente;
import com.unab.banca.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private IAdministradorDao iAdministradorDao;
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping(value="/")
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente){
        Cliente obj = clienteService.save(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }
   
    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Cliente> eliminar(@PathVariable String id){
        Cliente obj = clienteService.findById(id);
        if(obj!=null) 
            clienteService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){
        Cliente obj = clienteService.findById(cliente.getId_cliente());
        if(obj!=null) { 
            obj.setNombre_cliente(cliente.getNombre_cliente());
            obj.setClave_cliente(cliente.getClave_cliente());
            clienteService.save(obj); 
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list") 
    public List<Cliente> consultarTodo(){
        return clienteService.findAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Cliente consultaPorId(@PathVariable String id){
        return clienteService.findById(id); 
    }
    
}
