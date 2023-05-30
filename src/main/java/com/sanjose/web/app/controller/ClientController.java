
package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Client;
import com.sanjose.web.app.model.service.ClientService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author GLM
 */
@Controller
@RequestMapping("/clients")
public class ClientController {
    
    private final ClientService clientSvc;
    
    @Autowired
    public ClientController(ClientService clientService){
        clientSvc = clientService;
    }
    
    @RequestMapping(value = {"/listAll"}, method= RequestMethod.GET)
    public String listAll(@RequestParam(name = "keyword", defaultValue="") String name,
                @RequestParam(name = "page", defaultValue = "1") int page,
                @RequestParam(name = "size", defaultValue = "10") int size,
                @RequestParam(name = "sortField", defaultValue = "name") String sort,
                @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,                
            Model model){
        
        Page<Client> paging = clientSvc.findAll(page-1, size, sort, sortDir);
        //PageRender<Client> pageRender = new PageRender<Client>("/listAll", clients);
        
        model.addAttribute("title", "Cartera de clientes");
        model.addAttribute("clients", paging.getContent());
        model.addAttribute("totalPages", paging.getTotalPages());
        model.addAttribute("totalItems", paging.getTotalElements());
        model.addAttribute("currentPage", page);
        
        model.addAttribute("sortField", sort);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")? "desc" : "asc");
        
        return "client/listAll";
    }
    
    @GetMapping(value = "/detail/{id}")
    public String findById(@PathVariable(value="id") Long id, 
            Map<String, Object> model, 
            RedirectAttributes flash){
        
        Client client = clientSvc.findById(id);
        if(client==null){
            flash.addAttribute("error", "No se encontraron datos del cliente " + id);
            return "redirect:/client/listAll";
        }
        model.put("client", client);
        model.put("title", "Cliente " + id + "-" + client.getName());
        
        return "client/form";
    }
    
    
}
