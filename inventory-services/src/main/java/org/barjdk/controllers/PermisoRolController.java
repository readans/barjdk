package org.barjdk.controllers;

import lombok.extern.slf4j.Slf4j;
import org.barjdk.entity.PermisoRolEntity;
import org.barjdk.entity.RolEntity;
import org.barjdk.services.PermisoRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permisoRol")
@CrossOrigin(origins = "*")
@Slf4j
public class PermisoRolController {

    @Autowired
    PermisoRolService permisoRolService;

    @GetMapping(path = "/consultarPorRol")
    public List<PermisoRolEntity> consultarPorRol(@RequestBody RolEntity rolEntity) {
        return this.permisoRolService.consultarPorRol(rolEntity);
    }
}
